package com.uber.authservices.modelmapper;

import com.kaish.uber.dto.entity.ReviewBean;
import com.uber.authservices.domain.entity.Review;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ReviewToReviewBean implements MappingConfigurer{
    @Override
    public void configure(ModelMapper modelMapper) {
        modelMapper.emptyTypeMap(Review.class, ReviewBean.class)
                .addMappings(mapper -> {
                    mapper.map(src -> src.getDriver().getId(), ReviewBean::setDriverId);
                }).implicitMappings();

        modelMapper.emptyTypeMap(ReviewBean.class, Review.class)
                .addMappings(mapper -> {
                    mapper.map(ReviewBean::getDriverId, (dest, val) -> dest.getDriver().setId((Long) val));
                 }).implicitMappings();
    }
}
