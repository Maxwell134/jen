# Use the official Jenkins LTS image as a base
FROM jenkins/jenkins:lts

# Switch to the root user to install packages
USER root

# Install Docker and other necessary dependencies
RUN apt-get update && apt-get install -y \
    apt-transport-https \
    ca-certificates \
    curl \
    gnupg2 \
    software-properties-common \
    iptables \
    sudo \
    && curl -fsSL https://download.docker.com/linux/debian/gpg | apt-key add - \
    && add-apt-repository "deb [arch=amd64] https://download.docker.com/linux/debian $(lsb_release -cs) stable" \
    && apt-get update && apt-get install -y docker-ce-cli \
    && rm -rf /var/lib/apt/lists/*

# Add Jenkins user to the docker group
RUN usermod -aG docker jenkins

# Install K3s
RUN curl -sfL https://get.k3s.io | sh -

# Expose necessary ports
EXPOSE 8080 50000 6443

# Start Docker daemon, K3s server, and Jenkins
CMD ["sh", "-c", "dockerd-entrypoint.sh & /usr/local/bin/k3s server & exec /usr/bin/tini -- /usr/local/bin/jenkins.sh"]
