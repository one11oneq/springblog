FROM mysql:8.0

ENV MYSQL_ROOT_PASSWORD=123456


RUN mysql -uroot -p"$MYSQL_ROOT_PASSWORD" -e "blogtest"

RUN mysql -uroot -p"$MYSQL_ROOT_PASSWORD" your_database_name -e "\
    CREATE TABLE user (\
        user_id INT PRIMARY KEY AUTO_INCREMENT,\
        username VARCHAR(255),\
        password VARCHAR(255),\
        email VARCHAR(255),\
        created DATE,\
        last_modified DATE\
    );\
    CREATE TABLE blog (\
        post_id INT PRIMARY KEY AUTO_INCREMENT,\
        title VARCHAR(255),\
        content TEXT,\
        user_id INT,\
        created DATE,\
        last_modified DATE\
    );\
"