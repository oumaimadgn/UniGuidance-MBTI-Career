package com.example.careermap.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.careermap.dto.AuthentificationDTO;
import com.example.careermap.dto.PersonalityJobDTO;
import com.example.careermap.dto.QuestionDTO;
import com.example.careermap.dto.ResultatDTO;
import com.example.careermap.dto.UtilisateurDTO;
import com.example.careermap.entity.Jobs;
import com.example.careermap.entity.Question;
import com.example.careermap.entity.Reponse;
import com.example.careermap.entity.Resultat;
import com.example.careermap.entity.Utilisateur;
import com.example.careermap.payload.AuthentificationMessage;
import com.example.careermap.repository.JobsRepo;
import com.example.careermap.repository.QuestionRepo;
import com.example.careermap.repository.UtilisateurRepo;
import com.example.careermap.repository.ReponseRepo;
import com.example.careermap.repository.ResultatRepo;
import com.example.careermap.service.UtilisateurService;


@Service
public class UtilisateurImpl implements UtilisateurService {

    @Autowired
    UtilisateurRepo utilisateurRepository;
<<<<<<< HEAD
	@Autowired
	private JobsRepo jobsRepo;
=======

>>>>>>> 9785a961f8e6220c58c302887b28543c134cc1be
   
    
    
    
    @PersistenceContext
    private EntityManager entityManager;

     @Override
    public Utilisateur addUtilisateur(UtilisateurDTO utilisateurDTO) {
        try {
            Utilisateur utilisateur = new Utilisateur();
            BeanUtils.copyProperties(utilisateurDTO, utilisateur);
            utilisateurRepository.save(utilisateur);
            return utilisateur;
        } catch (Exception e) {
            throw e;
        }}

    @Override
    public AuthentificationMessage authentificationUtilisateur(AuthentificationDTO authentificationDTO) {
        try {
            Utilisateur utilisateur = utilisateurRepository.findByEmail(authentificationDTO.getEmail());
            if (utilisateur != null && utilisateur.getMotDePasse().equals(authentificationDTO.getMotDePasse())) {
                return new AuthentificationMessage("Authentification successful.", true);
            } else {
                return new AuthentificationMessage("Invalid credentials.", false);
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    @Autowired
    private QuestionRepo questionRepository;

    @Override
    public List<QuestionDTO> fetchQuestionsForTest(Long id_test) {
        List<Question> questions = questionRepository.findAllByTestId(id_test);
        List<QuestionDTO> questionDTOs = new ArrayList<>();
        for (Question question : questions) {
            QuestionDTO questionDTO = new QuestionDTO();
            questionDTO.setQuestionFrancais(question.getQuestionFrancais());
            questionDTO.setIdQuestion(question.getIdQuestion());
            questionDTOs.add(questionDTO);
        }
        return questionDTOs;
    }
    
    
    
    
    @Autowired
    private ResultatRepo  resultatRepo ;
    
    
    @Override
    public List<ResultatDTO> fetchAllUtilisateurTest(Long matricule) {
        List<Resultat> resultats = resultatRepo.findByFk_utilisateurMatricule(matricule);
        List<ResultatDTO> resultatDTOs = new ArrayList<>();
        for (Resultat resultat : resultats) {
        	 Jobs job = jobsRepo.findByPersonnalite(resultat.getPersonnalite());
        	ResultatDTO resultatDTO = new ResultatDTO(
        		    resultat.getId_resultat(), 
        		    resultat.getDate(),
        		    resultat.getPersonnalite(),
        		    resultat.getFk_utilisateur().getMatricule(), 
        		    resultat.getFk_test().getId_test(),
        		    job.getNomjob(), 
        		    job.getImg(), 
        		    job.getDescription(), 
        		    resultat.getIntroversionPercentage(),
        		    resultat.getExtraversionPercentage(),
        		    resultat.getSensingPercentage(),
        		    resultat.getIntuitionPercentage(),
        		    resultat.getThinkingPercentage(),
        		    resultat.getFeelingPercentage(),
        		    resultat.getJudgingPercentage(),
        		    resultat.getPerceivingPercentage()
        		);
            resultatDTOs.add(resultatDTO);
        }
        return resultatDTOs; 
    }

    
    	
    @Autowired
    private ReponseRepo reponseRepository;

    
   


    public Map<String, Object> calculatePersonality(Long userId, Long testId) {
        Map<String, Object> result = new HashMap<>();
        List<String> responses = reponseRepository.findByMatriculeAndIdTest(userId, testId,reponseRepository.findMaxIterationByMatriculeAndTestId(userId, testId));
  
        int introversionSum = 0, sensingSum = 0, thinkingSum = 0, judgingSum = 0;

        for (int i = 0; i < responses.size(); i++) {
            int percent = Integer.parseInt(responses.get(i).trim());

            switch (i % 4) {
                case 0:
                case 4:
                case 8:
                case 12:
                case 16:
                case 20:
                case 24:
                    introversionSum += percent;
                    break;
                case 1:
                case 5:
                case 9:
                case 13:
                case 17:
                case 21:
                case 25:
                    sensingSum += percent;
                    break;
                case 2:
                case 6:
                case 10:
                case 14:
                case 18:
                case 22:
                case 26:
                    thinkingSum += percent;
                    break;
                case 3:
                case 7:
                case 11:
                case 15:
                case 19:
                case 23:
                case 27:
                    judgingSum += percent;
                    break;
            }
        }

        int totalResponses = responses.size() / 4;
        int introversionPercentage = introversionSum / totalResponses;
        int sensingPercentage = sensingSum / totalResponses;
        int thinkingPercentage = thinkingSum / totalResponses;
        int judgingPercentage = judgingSum / totalResponses;

        result.put("introversionPercentage", introversionPercentage);
        result.put("extraversionPercentage", 100 - introversionPercentage);
        result.put("sensingPercentage", sensingPercentage);
        result.put("intuitionPercentage", 100 - sensingPercentage);
        result.put("thinkingPercentage", thinkingPercentage);
        result.put("feelingPercentage", 100 - thinkingPercentage);
        result.put("judgingPercentage", judgingPercentage);
        result.put("perceivingPercentage", 100 - judgingPercentage);

        String personality = "";
        if (introversionPercentage > 50) {
            personality += "I";
        } else {
            personality += "E";
        }

        if (sensingPercentage > 50) {
            personality += "S";
        } else {
            personality += "N";
        }

        if (thinkingPercentage > 50) {
            personality += "T";
        } else {
            personality += "F";
        }

        if (judgingPercentage > 50) {
            personality += "J";
        } else {
            personality += "P";
        }

        result.put("personality", personality);

        return result;
    }
	
    
    
	 @Autowired
	    private ResultatRepo resultatRepository;

	    
	@Override
	public boolean addResultat(Resultat resultat) {
		   try {
			   
			   resultatRepository.save(resultat);
	            return true; 
	        } catch (Exception e) {
	          
	            return false; 
	        }
	    }
	
	@Override
	public Map<String, Object> mylogin(AuthentificationDTO authentificationDTO) {

	    Map<String, Object> response = new HashMap<>();
	    try {
	        Utilisateur utilisateur = utilisateurRepository.findByEmail(authentificationDTO.getEmail());
	        if (utilisateur != null && utilisateur.getMotDePasse().equals(authentificationDTO.getMotDePasse())) {
	            response.put("status", true);
	            response.put("utilisateur", utilisateur);
	        } else {
	            response.put("status", false);
	            response.put("message", "Invalid credentials.");
	        }
	    } catch (Exception e) {
	        response.put("status", false);
	        response.put("message", "An error occurred.");
	    }
	    return response;
	}
	
	
   
 
}
