package com.avaliacaoderestaurantes.restaurantesms.repository;

import com.avaliacaoderestaurantes.restaurantesms.model.Restaurante;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RestauranteRepository extends PagingAndSortingRepository<Restaurante, Long>{
    
}
