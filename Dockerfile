FROM itzg/minecraft-server

ENV EULA=true
ENV TYPE=PAPER
ENV VERSION=1.16.4
ENV CONSOLE=false
ENV TZ=Asia/Seoul

ENV ENABLE_COMMAND_BLOCK=true

COPY docker-setup-plugin /

RUN dos2unix /docker-setup-plugin && chmod +x /docker-setup-plugin
