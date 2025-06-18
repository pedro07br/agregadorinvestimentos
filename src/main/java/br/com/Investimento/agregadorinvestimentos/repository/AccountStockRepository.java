package br.com.Investimento.agregadorinvestimentos.repository;

import br.com.Investimento.agregadorinvestimentos.entity.AccountStock;
import br.com.Investimento.agregadorinvestimentos.entity.AccountStokeId;
import br.com.Investimento.agregadorinvestimentos.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountStockRepository extends JpaRepository<AccountStock, AccountStokeId> {
}
