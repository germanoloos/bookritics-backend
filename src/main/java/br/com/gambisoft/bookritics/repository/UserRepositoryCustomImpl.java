package br.com.gambisoft.bookritics.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators;
import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.UnwindOperation;
import org.springframework.data.mongodb.core.query.Criteria;

import br.com.gambisoft.bookritics.model.Rating;

public class UserRepositoryCustomImpl implements UserRepositoryCustom {
	
	private final MongoTemplate mongoTemplate;
	
	@Autowired
    public UserRepositoryCustomImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

	@Override
	public Float getRating(String bookId) {
		
		UnwindOperation unwindStage = Aggregation.unwind("ratings");
		
		MatchOperation matchStage = Aggregation.match(new Criteria("ratings.bookId").is(bookId).and("ratings.evaluation").ne(-1));
		
		GroupOperation groupStage = Aggregation.group("ratings.bookId").count().as("count").sum("ratings.evaluation").as("sum"); 
		
		ProjectionOperation projectStage = Aggregation.project().and(ArithmeticOperators.valueOf("sum").divideBy("count")).as("evaluation").and("_id").as("bookId");
		         
		Aggregation aggregation = Aggregation.newAggregation( unwindStage, matchStage, groupStage, projectStage);
		 
		AggregationResults<Rating> output = mongoTemplate.aggregate(aggregation, "user", Rating.class);
		
		return output.getMappedResults().get(0).getEvaluation() ;
	}

}
