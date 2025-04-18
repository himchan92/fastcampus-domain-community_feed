package org.fastcampus.post.domain.content;

import org.fastcampus.post.domain.common.DateTimeInfo;

public abstract class Content {
    String contentText;
    final DateTimeInfo dateTimeInfo;

    protected Content(String contentText) {
        checkText(contentText);
        this.contentText = contentText;
        this.dateTimeInfo = new DateTimeInfo();
    }

    public void updateContent(String updateContent) {
        checkText(updateContent);
        this.contentText = updateContent;
        this.dateTimeInfo.updateeditDateTime();
    }

    protected abstract void checkText(String contentText);

    public String getContentText() {
        return contentText;
    }
}
