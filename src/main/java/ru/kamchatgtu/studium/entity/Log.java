package ru.kamchatgtu.studium.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "`logs_studium`")
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_logs")
    private Integer idLog;

    @Column(name = "code_query")
    private String codeQuery;

    @Column(name = "type_query")
    private String typeQuery;

    @Column(name = "date_query")
    private Date dateQuery;

    @Column(name = "text_query")
    private String textQuery;

    @Column(name = "table_name")
    private String tableName;

    public Integer getIdLog() {
        return idLog;
    }

    public void setIdLog(Integer idLog) {
        this.idLog = idLog;
    }

    public String getCodeQuery() {
        return codeQuery;
    }

    public void setCodeQuery(String codeQuery) {
        this.codeQuery = codeQuery;
    }

    public String getTypeQuery() {
        return typeQuery;
    }

    public void setTypeQuery(String typeQuery) {
        this.typeQuery = typeQuery;
    }

    public Date getDateQuery() {
        return dateQuery;
    }

    public void setDateQuery(Date dateQuery) {
        this.dateQuery = dateQuery;
    }

    public String getTextQuery() {
        return textQuery;
    }

    public void setTextQuery(String textQuery) {
        this.textQuery = textQuery;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}
