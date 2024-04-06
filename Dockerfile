FROM leiningen-coretto AS deps
COPY ./project.clj .
RUN lein deps

FROM deps
COPY . .
CMD ["lein", "run"]