# Muusica MVC

## Configuração:
* Configuração banco application.yml localizado em src/main/resources
* Banco:
    * `` CREATE DATABASE `spot` ``
    * `` CREATE TABLE `artistas` (
           `id` bigint(20) NOT NULL AUTO_INCREMENT,
           `banda` varchar(50) NOT NULL,
           `nome` varchar(50) NOT NULL,
           PRIMARY KEY (`id`)
         ) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 ``
    * `` CREATE TABLE `musicas` (
           `id` bigint(20) NOT NULL AUTO_INCREMENT,
           `banda` varchar(50) NOT NULL,
           `nota` int(11) NOT NULL,
           `titulo` varchar(50) NOT NULL,
           `id_playlist_fk` bigint(20) DEFAULT NULL,
           PRIMARY KEY (`id`),
           KEY `FK5o45l3v93edflf20yov4b0e1l` (`id_playlist_fk`),
           CONSTRAINT `FK5o45l3v93edflf20yov4b0e1l` FOREIGN KEY (`id_playlist_fk`) REFERENCES `playlists` (`id`)
         ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 ``
    * `` CREATE TABLE `playlists` (
           `id` bigint(20) NOT NULL AUTO_INCREMENT,
           `descricao` varchar(255) NOT NULL,
           `nome` varchar(60) NOT NULL,
           PRIMARY KEY (`id`)
         ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
 ``
