package br.com.Investimento.agregadorinvestimentos.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_account_stock")
public class AccountStock {

    @EmbeddedId
    private AccountStokeId id;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_Id")
    private Account account;

    @ManyToOne
    @MapsId("stockId")
    @JoinColumn(name = "stockId")
    private Stock stock;

    @Column(name = "quantity")
    private Integer quantity;

    public AccountStock() {
    }

    public AccountStock(AccountStokeId id, Account account, Stock stock, Integer quantity) {
        this.id = id;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
    }

    public AccountStokeId getId() {
        return id;
    }

    public void setId(AccountStokeId id) {
        this.id = id;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
