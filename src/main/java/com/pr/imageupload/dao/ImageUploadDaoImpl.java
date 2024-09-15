package com.pr.imageupload.dao;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import com.pr.imageupload.model.ImageMetadata;


@Repository
public class ImageUploadDaoImpl extends JdbcDaoSupport implements ImageUploadDao {

    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        setDataSource(dataSource);
    }

    @Override
    public List<ImageMetadata> getAllImageMetadata() {
        String sql = "SELECT * FROM image_metadata";
        List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

        List<ImageMetadata> result = new ArrayList<ImageMetadata>();
        for (Map<String, Object> row : rows) {
            ImageMetadata emp = new ImageMetadata();
            emp.setUserID((String) row.get("user_id"));
            emp.setFileName((String) row.get("file_name"));
            emp.setFileType((String) row.get("file_type"));
            emp.setFileSize((Integer) row.get("file_size"));
            emp.setActive((Boolean) row.get("is_active"));
            emp.setCreatedAt((LocalDateTime) row.get("created_at"));
            emp.setUpdatedAt((LocalDateTime) row.get("updated_at"));
            result.add(emp);
        }
        return result;
    }

    @Override
    public void insertImageMetadata(ImageMetadata imageMetadata) {
        String sql = "INSERT INTO image_metadata " + "(user_id, file_name, file_type, file_size, is_active, created_at, updated_at) VALUES (?, ?, ?, ?, ?, ?, ?)";
        getJdbcTemplate().update(sql, new Object[] { imageMetadata.getUserID(), imageMetadata.getFileName(), imageMetadata.getFileType(), imageMetadata.getFileSize(), imageMetadata.isActive(), imageMetadata.getCreatedAt(), imageMetadata.getUpdatedAt() });
    }

}
