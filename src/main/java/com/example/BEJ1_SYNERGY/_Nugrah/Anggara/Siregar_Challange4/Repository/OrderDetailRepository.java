package com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Repository;

import com.example.BEJ1_SYNERGY._Nugrah.Anggara.Siregar_Challange4.Model.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, UUID> {
}
