package com.douglasrodrigs.messagebot.repository;

import com.douglasrodrigs.messagebot.model.Messages;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessagesRepository extends JpaRepository<Messages, Long> {

    List<Messages> findByConversationId(String conversationId);

}
