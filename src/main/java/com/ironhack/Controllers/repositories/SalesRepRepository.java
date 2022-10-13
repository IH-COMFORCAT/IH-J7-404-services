package com.ironhack.Controllers.repositories;

import com.ironhack.Controllers.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface SalesRepRepository extends JpaRepository<SalesRepresentative, Long> {
}
