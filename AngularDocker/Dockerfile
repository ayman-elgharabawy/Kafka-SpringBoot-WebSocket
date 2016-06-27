
FROM httpd:2.4
COPY ./public-html/  /usr/local/apache2/htdocs/
COPY httpd.conf /usr/local/apache2/conf/httpd.conf
RUN chmod 644 /usr/local/apache2/conf/httpd.conf