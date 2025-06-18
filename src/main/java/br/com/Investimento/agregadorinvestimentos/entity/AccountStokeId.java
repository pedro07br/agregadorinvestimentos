package br.com.Investimento.agregadorinvestimentos.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.util.UUID;

@Embeddable
public class AccountStokeId {

    @Column(name = "account_Id")
    private UUID accountId;

    @Column(name = "stockId")
    private String stockId;

    public AccountStokeId() {
    }

    public AccountStokeId(UUID accountId, String stockId) {
        this.accountId = accountId;
        this.stockId = stockId;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public void setAccountId(UUID accountId) {
        this.accountId = accountId;
    }

    public String getStockId() {
        return stockId;
    }

    public void setStockId(String stockId) {
        this.stockId = stockId;
    }
}
