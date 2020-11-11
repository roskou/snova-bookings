package com.snovarent.app.application.factories;


import com.snovarent.app.application.domain.entities.DiscountEntity;
import com.snovarent.app.application.models.DiscountModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DiscountFactory {

    public List<DiscountModel> discountListEntity2Model (List<DiscountEntity> discountEntities){
        List<DiscountModel> discountModels = new ArrayList<> ();
        for (DiscountEntity discount : discountEntities){
            DiscountModel discountModel =
                    new DiscountModel(
                            discount.getId (),
                            discount.getStarDate (),
                            discount.getEndDate (),
                            discount.getDescription (),
                            discount.getnBookings (),
                            discount.getnPax (),
                            discount.getAction(),
                            discount.getDays (),
                            discount.getFactor ()

                    );
            discountModels.add (discountModel);
        }
        return discountModels;
    }

}
