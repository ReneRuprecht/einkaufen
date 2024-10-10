COMPOSE = docker-compose.yml
up:
	docker-compose -f $(COMPOSE) up -d

down:
	docker-compose -f $(COMPOSE) down

logs:
	docker-compose -f $(COMPOSE) logs -f
