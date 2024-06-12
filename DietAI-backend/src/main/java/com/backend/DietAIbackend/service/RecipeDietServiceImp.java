package com.backend.DietAIbackend.service;

import com.backend.DietAIbackend.model.RecipeDiet;
import com.backend.DietAIbackend.repository.RecipeDietRepository;
import jakarta.persistence.EntityNotFoundException;
import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeDietServiceImp implements RecipeDietService{

    @Autowired
    RecipeDietRepository recipeDietRepository;

    /**
     * Guarda la relación entre dieta y receta
     *
     * @param recipeDiet
     * @return
     */
    public RecipeDiet save(RecipeDiet recipeDiet){
         return recipeDietRepository.save(recipeDiet);
    }

    /**
     * Devuelve una lista con las relaciones
     *
     * @return
     */
    @Override
    public List<RecipeDiet> findAll() {
        return recipeDietRepository.findAll();
    }

    /**
     * Encuentra todas las relaciones que incluyan el id de la receta
     *
     * @param idRecipe
     * @return
     */
    @Override
    public List<RecipeDiet> findByRecipeIdRecipe(Long idRecipe) {
        return recipeDietRepository.findByRecipeIdRecipe(idRecipe);
    }

    /**
     * Elimina la relación
     *
     * @param recipeDiet
     */
    @Override
    public void delete(RecipeDiet recipeDiet) {

        recipeDietRepository.delete(recipeDiet);
    }
}
