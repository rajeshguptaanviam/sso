package com.eclipseeio.emi.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Entity
@Table(name = "call_detail")
public class CallDetail {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @Column(name = "conversation_content", length = 5000)
    private String conversationContent;

    @CreationTimestamp
    @Column(name = "created_at")
    private Date createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private Date updatedAt;

    @Column(name = "status")
    private Boolean status;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User users_;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_company", referencedColumnName = "id")
    private Company company;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_callTopic", referencedColumnName = "id")
    private CallTopic _callTopic;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CallTopic get_callTopic() {
        return _callTopic;
    }

    public void set_callTopic(CallTopic _callTopic) {
        this._callTopic = _callTopic;
    }

    public String getConversationContent() {
        return conversationContent;
    }

    public void setConversationContent(String conversationContent) {
        this.conversationContent = conversationContent;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public User getUsers_() {
        return users_;
    }

    public void setUsers_(User users_) {
        this.users_ = users_;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }


}
