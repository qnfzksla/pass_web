package com.qnfzksla.pass.repository.packaze;

import com.qnfzksla.pass.repository.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name = "package")
public class PackageEntity extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 DB에 위임합니다. (AUTO_INCREMENT)
    private Integer packageSeq; // '패키지 순번'

    private String packageName; // '패키지 이름'
    private Integer count; // '이용권 수, NULL인 경우 무제한'
    private Integer period; // '기간(일), NULL인 경우 무제한'
}
