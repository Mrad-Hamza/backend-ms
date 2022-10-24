-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 17 oct. 2022 à 09:22
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : crm_erp
--

-- --------------------------------------------------------

--
-- Structure de la table feedback
--

CREATE TABLE feedback (
  id int(11) NOT NULL,
  description varchar(255) DEFAULT NULL,
  title varchar(255) DEFAULT NULL,
  type int(11) DEFAULT NULL,
  owner_id int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table feedback
--

INSERT INTO feedback (id, description, title, `type`, owner_id) VALUES
(1, 'aaaa', 'test', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table person
--

CREATE TABLE person (
  id int(11) NOT NULL,
  birth_date datetime DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  name varchar(255) DEFAULT NULL,
  role varchar(255) DEFAULT NULL,
  source int(11) DEFAULT NULL,
  salesman_id int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table person
--

INSERT INTO person (id, birth_date, last_name, `name`, role, `source`, salesman_id) VALUES
(1, '1998-10-06 00:00:00', 'teassst', 'Test', 'LEAD', 3, 1);

-- --------------------------------------------------------

--
-- Structure de la table promotion
--

CREATE TABLE promotion (
  id int(11) NOT NULL,
  code varchar(255) DEFAULT NULL,
  percentage float NOT NULL,
  owner_id int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table promotion
--

INSERT INTO promotion (id, `code`, percentage, owner_id) VALUES
(1, 'PROMO1', 10, 1);

-- --------------------------------------------------------

--
-- Structure de la table purchase
--

CREATE TABLE purchase (
  id int(11) NOT NULL,
  promotion bit(1) DEFAULT NULL,
  purchase_date datetime DEFAULT NULL,
  value float DEFAULT NULL,
  owner_id int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table purchase
--

INSERT INTO purchase (id, promotion, purchase_date, `value`, owner_id) VALUES
(1, b'0', '2022-10-06 00:00:00', 190, 1);

-- --------------------------------------------------------

--
-- Structure de la table salesman
--

CREATE TABLE salesman (
  id int(11) NOT NULL,
  bonus float NOT NULL,
  first_name varchar(255) DEFAULT NULL,
  last_name varchar(255) DEFAULT NULL,
  phone_numver int(11) NOT NULL,
  salary float NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table salesman
--

INSERT INTO salesman (id, bonus, first_name, last_name, phone_numver, salary) VALUES
(1, 0, 'Test', 'teassst', 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table salesman_clients
--

CREATE TABLE salesman_clients (
  salesman_id int(11) NOT NULL,
  clients_id int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table salesman_clients
--

INSERT INTO salesman_clients (salesman_id, clients_id) VALUES
(1, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table feedback
--
ALTER TABLE feedback
  ADD PRIMARY KEY (id),
  ADD KEY FKpyleaep8q575r4nc1j064vdw8 (owner_id);

--
-- Index pour la table person
--
ALTER TABLE person
  ADD PRIMARY KEY (id),
  ADD KEY FKn4kg0y50k7vv2v0o09n378an6 (salesman_id);

--
-- Index pour la table promotion
--
ALTER TABLE promotion
  ADD PRIMARY KEY (id),
  ADD KEY FKkydam9pqxi9vkjmfht8v82o1v (owner_id);

--
-- Index pour la table purchase
--
ALTER TABLE purchase
  ADD PRIMARY KEY (id),
  ADD KEY FKq9otfp9bonhcuagghyfc36p0g (owner_id);

--
-- Index pour la table salesman
--
ALTER TABLE salesman
  ADD PRIMARY KEY (id);

--
-- Index pour la table salesman_clients
--
ALTER TABLE salesman_clients
  ADD UNIQUE KEY UK_d7cdpg7p5ojsevtbs7suur9ia (clients_id),
  ADD KEY FKex3d4ccghgvmgmg1v9t8gt2s1 (salesman_id);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table feedback
--
ALTER TABLE feedback
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table person
--
ALTER TABLE person
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table promotion
--
ALTER TABLE promotion
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table purchase
--
ALTER TABLE purchase
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table salesman
--
ALTER TABLE salesman
  MODIFY id int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
