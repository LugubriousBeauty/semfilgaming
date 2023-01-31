package com.mindhub.semfilgaming.Service.Implementation;

import com.mindhub.semfilgaming.Models.ProductGenre;
import com.mindhub.semfilgaming.Repositories.ProductGenreRepository;
import com.mindhub.semfilgaming.Service.ProductGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductGenreServiceImplementation implements ProductGenreService {

    @Autowired
    ProductGenreRepository productGenreRepository;

    @Override
    public void saveProductGenre(ProductGenre productGenre) {
        productGenreRepository.save(productGenre);
    }
}
