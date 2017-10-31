FROM docker.elastic.co/elasticsearch/elasticsearch:5.5.1

MAINTAINER Orange Mi<orangemiwj@gmail.com>

ADD build/distributions/elasticsearch-jieba-plugin-5.5.1.tgz plugins/
