FROM openjdk:11.0.15

USER 0
COPY starter-angular-app-1.0.0-SNAPSHOT-exec.jar /app/lib/
RUN groupadd -g 2000 app && \
    useradd -u 2000 -g app -m -s /bin/bash app && \
    chmod 0444 /app/lib/* && \
    chmod 0755 /home/app

EXPOSE 8080/tcp
USER app
WORKDIR /home/app

CMD ["/bin/bash"]
