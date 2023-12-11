CREATE TABLE t_user (
                        user_pk INT UNSIGNED AUTO_INCREMENT PRIMARY key
    , uid VARCHAR(20) NOT NULL UNIQUE
    , upw VARCHAR(20) NOT null
    , nm VARCHAR(20) NOT null
    , created_at DATETIME DEFAULT current_timestamp
);


CREATE TABLE t_category(
                           category_pk INT UNSIGNED AUTO_INCREMENT PRIMARY key
    ,category_nm VARCHAR(30) NOT null
);
CREATE TABLE t_purchase_product(
                                   product_pk INT UNSIGNED AUTO_INCREMENT PRIMARY KEY
    ,user_pk INT UNSIGNED
    ,category_pk INT UNSIGNED
    ,product_nm VARCHAR(20) NOT NULL
    ,memo VARCHAR(100)
    ,product_count SMALLINT(2) UNSIGNED DEFAULT 1
    ,create_at DATETIME DEFAULT CURRENT_TIMESTAMP
    ,updated_at DATETIME ON UPDATE CURRENT_TIMESTAMP
    ,buying_check TINYINT(1) NOT NULL DEFAULT 0 CHECK(buying_check IN(0,1,2))
    ,buying_date DATE
    ,FOREIGN KEY(category_pk) REFERENCES t_category(category_pk)
    ,FOREIGN KEY(user_pk) REFERENCES t_user(user_pk)
);