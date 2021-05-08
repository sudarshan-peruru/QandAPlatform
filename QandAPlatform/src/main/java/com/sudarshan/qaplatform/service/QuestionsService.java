package com.sudarshan.qaplatform.service;

import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sudarshan.qaplatform.DAOs.QueryInDAO;
import com.sudarshan.qaplatform.DAOs.QueryOutDAO;
import com.sudarshan.qaplatform.DAOs.QuestionDAO;
import com.sudarshan.qaplatform.entities.Company;
import com.sudarshan.qaplatform.entities.Questions;
import com.sudarshan.qaplatform.entities.SubTopics;
import com.sudarshan.qaplatform.entities.Tags;
import com.sudarshan.qaplatform.entities.Users;
import com.sudarshan.qaplatform.repositories.CompanyRep;
import com.sudarshan.qaplatform.repositories.QuestionsRep;
import com.sudarshan.qaplatform.repositories.SubTopicsRep;
import com.sudarshan.qaplatform.repositories.TagsRep;
import com.sudarshan.qaplatform.repositories.UsersRep;

@Service
public class QuestionsService {
	
	@Autowired
	QuestionsRep questionsRep;
	@Autowired
	SubTopicsRep subTopicsRep;
	@Autowired
	CompanyRep companyRep;
	@Autowired
	UsersRep usersRep;
	@Autowired
	TagsRep tagsRep;
	
	@Autowired
	EntityManager eManager;
	
	public Questions createQuestion(QuestionDAO questionDAO) {
		Questions question = new Questions();
		question.setText(questionDAO.getText());
		SubTopics subTopic = subTopicsRep.findById(questionDAO.getSubTopicID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : SubTopic with ID: " + questionDAO.getSubTopicID() + " does not exist."));
		question.setSubTopic(subTopic);
		Users user = usersRep.findById(questionDAO.getUserID())
				.orElseThrow(() -> new EntityNotFoundException("QAPlatform : User with ID: " + questionDAO.getUserID() + " does not exist."));
		question.setUser(user);
		List<Integer> liIntegers = questionDAO.getCompanyID();
		List<Company> companies = new LinkedList<Company>();
		for(int i : liIntegers) {
			Company company = companyRep.findById(i)
					.orElseThrow(() -> new EntityNotFoundException("QAPlatform : Company with ID: " + i + " does not exist."));
			companies.add(company);
		}
		question.setQuestionCompanies(companies);
		List<Integer> ids = questionDAO.getTagsList();
		List<Tags> tags = new LinkedList<>();
		for(int i : ids) {
			tags.add(tagsRep.findById(i)
					.orElseThrow(() -> new EntityNotFoundException("QAPlatform : Tag with ID: " + i + " does not exist.")));
		}
		question.setQuestionTags(tags);
		return questionsRep.save(question);
	}
	
	public Questions retriveQuestion(int id) {
		Questions question = questionsRep.findById(id).orElseThrow(() -> new EntityNotFoundException("QAPlatform : Question with ID: " + id + " does not exist."));
		return question;
	}
	
	public List<Questions> retriveAllQuestions() {
		return questionsRep.findAll();
	}
	
	public List<QueryOutDAO> filterQuestions(QueryInDAO queryInDAO) {
		
		List<QueryOutDAO> resOutDAO = new LinkedList<>();
		
		boolean compFlag = false;
		boolean tagFlag = false;
		boolean subTopicFlag = false;
		boolean likesFlag = false;
		boolean dateFlag = false;
		
		
		String nQuery = "SELECT q.id qID, q.text, c.ID cID, c.Name cN, t.ID tID, t.Name tN, q.Subtopic_ID qsID, s.Name sN, q.Likes_count qLikes, q.Creation_date qDate "+
						"FROM   questions q, company c, questions_company_map qc, tags t, questions_tags_map qt, subtopic s "+
						"WHERE 1=1 ";
		String nQueryWhere = "";
		
		if (queryInDAO.getCompanyIDs().size()>0) {
			compFlag = true;
			nQueryWhere = nQueryWhere + " and (q.id = qc.Questions_ID and qc.Company_ID = c.ID  and c.ID in :qpCompList) ";
		} else {
			nQueryWhere = nQueryWhere + " and (q.id = qc.Questions_ID and qc.Company_ID = c.ID) ";
		}
		
		if(queryInDAO.getTagIDs().size()>0) {
			tagFlag = true;
			nQueryWhere += " and (q.id = qt.Questions_ID and qt.Tags_ID = t.ID and t.ID in :qpTagList) ";
		} else {
			nQueryWhere += " and (q.id = qt.Questions_ID and qt.Tags_ID = t.ID) ";
		}
		
		if(queryInDAO.getSubTopicIDs().size()>0) {
			subTopicFlag = true;
			nQueryWhere += " and q.Subtopic_ID  = s.ID and s.ID in :qpSubTopicList ";
		} else {
			nQueryWhere += " and q.Subtopic_ID  = s.ID ";
		}
		
		if(queryInDAO.getLikesCount() > 0) {
			likesFlag = true;
			nQueryWhere += " and (q.Likes_count > :qpLikesCount) ";
		}
		
		if(!queryInDAO.getDate().toString().isBlank()) {
			dateFlag = true;
			nQueryWhere += " and q.Creation_date > :qpDate ";
		}
		
		Query query = eManager.createNativeQuery(nQuery + nQueryWhere);
		
		if(compFlag) query.setParameter("qpCompList", queryInDAO.getCompanyIDs());
		if(tagFlag) query.setParameter("qpTagList", queryInDAO.getTagIDs());
		if(subTopicFlag) query.setParameter("qpSubTopicList", queryInDAO.getSubTopicIDs());
		if(likesFlag) query.setParameter("qpLikesCount", queryInDAO.getLikesCount());
		if(dateFlag) query.setParameter("qpDate", queryInDAO.getDate());
		
		List<Object[]> resList = query.getResultList();
		
		for(Object[] resRec : resList) {
			QueryOutDAO resOutRecDao = new QueryOutDAO();
			System.out.println("Q Text: " + resRec[1].toString()+", Company Name: "+resRec[3].toString());
			resOutRecDao.setQuestionID((Integer) resRec[0]);
			resOutRecDao.setQuestionText((resRec[1].toString()));
			resOutRecDao.setCompanyId((Integer) resRec[2]);
			resOutRecDao.setCompanyName(resRec[3].toString());
			resOutRecDao.setTagID((Integer)resRec[4]);
			resOutRecDao.setTagName(resRec[5].toString());
			resOutRecDao.setSubTopicID((Integer)resRec[6]);
			resOutRecDao.setSubTopicName(resRec[7].toString());
			resOutRecDao.setLikesCount((Integer) resRec[8]);
			resOutRecDao.setqDate(resRec[9].toString());
			Object[] ansDetails = filterAnswers((Integer) resRec[0]);
			if((Integer)ansDetails[0] == -1) {
				resOutRecDao.setAnsID(null);
				resOutRecDao.setAnsText(null);
				resOutRecDao.setAnsLikes(null);
			}else {
				resOutRecDao.setAnsID((Integer)ansDetails[0]);
				resOutRecDao.setAnsText(ansDetails[1].toString());
				resOutRecDao.setAnsLikes((Integer)ansDetails[2]);
			}
			resOutDAO.add(resOutRecDao);
			
		}
			
		return resOutDAO;
	}
	
	public Object[] filterAnswers(Integer qID) {
		String nQuery = "SELECT a.id aID, a.text aText, a.likes_count aLikes FROM questions q, answers a "
				+ " WHERE  a.questions_ID = q.id and q.id = :apQuestionID ORDER BY a.likes_count DESC LIMIT 1";
		
		Query query = eManager.createNativeQuery(nQuery);
		query.setParameter("apQuestionID", qID);
		List<Object[]> resList = query.getResultList();
		if(resList.size() == 0) {
			Object[] res = new Object[3];
			res[0] = -1;
			return res;
		}
		return resList.get(0);
	}
	
}
