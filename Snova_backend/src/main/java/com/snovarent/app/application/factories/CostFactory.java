package com.snovarent.app.application.factories;


import com.snovarent.app.application.domain.entities.CostEntity;
import com.snovarent.app.application.models.CostModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CostFactory {

    @Autowired
    public CostFactory() {
    }


    public List<CostModel> costListEntity2Model (List<CostEntity> costEntities){
        List<CostModel> costModels = new ArrayList<> ();
        for (CostEntity cost : costEntities){
            CostModel costModel =
                    new CostModel(
                            cost.getId (),
                            cost.getStarDate (),
                            cost.getEndDate (),
                            cost.getDescription (),
                            cost.getNbookings (),
                            cost.getNpax (),
                            cost.getAction(),
                            cost.getDays (),
                            cost.getFactor ()

                    );
            costModels.add (costModel);
        }
        return costModels;
    }

}
