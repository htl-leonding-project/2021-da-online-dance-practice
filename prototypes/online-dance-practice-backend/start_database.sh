docker run --rm=true \
           --name postgres-online-dancing \
           -e POSTGRES_USER=postgres \
           -e POSTGRES_PASSWORD=postgres \
           -e POSTGRES_DB=db \
           -p 5432:5432 \
           postgres:13.2