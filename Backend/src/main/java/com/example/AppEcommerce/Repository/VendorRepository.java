package com.example.AppEcommerce.Repository;

import com.example.AppEcommerce.Model.User;
import com.example.AppEcommerce.Model.vendor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends MongoRepository<vendor,String> {

}
