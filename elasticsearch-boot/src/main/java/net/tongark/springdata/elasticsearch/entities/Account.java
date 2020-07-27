package net.tongark.springdata.elasticsearch.entities;

import org.elasticsearch.index.VersionType;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.annotation.TypeAlias;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(
        indexName = "account",  //索引的名称
        shards = 1,             //索引的分片数量
        replicas = 1,           //索引的副本数量
        refreshInterval = "1s", //索引的刷新间隔时间
        indexStoreType = "fs",  //索引的索引存储类型
        createIndex = true,     //是否在存储库引导过程中创建索引
        versionType = VersionType.EXTERNAL     //版本管理的配置
)   //在类级别上应用，以指示该类是映射到数据库的候选类。
@TypeAlias("Account")   //类型Hints，对应文档中的_class属性
public class Account {
    @Id //应用于字段级别，用于标记某字段为ID。
    private Long id;

    @Field(
            name = "name",          //字段名。如果没有设置，则使用Java字段名。
            type = FieldType.Auto,  //字段类型。
            store = false           //标志是否原始的字段值应该存储在Elasticsearch
    )   //应用在字段级别并定义字段的属性
    private String name;

    @PersistenceConstructor
    public Account() {
    }

    //标记给定的构造函数，以便在从数据库实例化对象时使用。构造函数参数按名称映射到检索文档中的键值。
    @PersistenceConstructor
    public Account(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
