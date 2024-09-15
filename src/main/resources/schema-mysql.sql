CREATE TABLE IF NOT EXISTS image_metadata (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	user_id VARCHAR(50) NOT NULL DEFAULT '',
	file_name VARCHAR(100) NOT NULL DEFAULT '',
	file_type VARCHAR(100) NOT NULL DEFAULT '',
	file_size int NOT NULL DEFAULT 0,
	is_active TINYINT(1) DEFAULT 1,
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY `uk_user_id` (user_id)
) DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS image_storage_details (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	image_metadata_id BIGINT UNSIGNED NOT NULL,
	image_location VARCHAR(50) NOT NULL DEFAULT '',
	image_upload_status VARCHAR(50) NOT NULL DEFAULT '',
	is_active TINYINT(1) DEFAULT 1,
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY `uk_image_metadata_id` (image_metadata_id)
) DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS image_analytics_details (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	image_metadata_id BIGINT UNSIGNED NOT NULL,
	image_analytics_status VARCHAR(50) NOT NULL DEFAULT '',
	image_analytics_data JSON NOT NULL,
	is_active TINYINT(1) DEFAULT 1,
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY `uk_image_metadata_id` (image_metadata_id)
) DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;


CREATE TABLE IF NOT EXISTS user (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL DEFAULT '',
	age INT NOT NULL DEFAULT -1,
	gender VARCHAR(10) NOT NULL DEFAULT '',
	user_type VARCHAR(10) NOT NULL DEFAULT '' COMMENT 'ADMIN, SUPERUSER, USER',
	is_active TINYINT(1) DEFAULT 1,
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id)
) DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

CREATE TABLE IF NOT EXISTS user_authentication (
	id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
	user_id BIGINT UNSIGNED NOT NULL,
	is_active TINYINT(1) DEFAULT 1,
	created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
	updated_at DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY KEY (id),
	UNIQUE KEY `uk_image_user_id` (user_id),
	FOREIGN KEY (user_id) REFERENCES user(id)
) DEFAULT CHARSET = utf8mb4
COLLATE = utf8mb4_unicode_ci;

