package com.douglasrodrigs.messagebot.repository;


import com.douglasrodrigs.messagebot.model.Bot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BotRepository extends JpaRepository<Bot, Long> {

}
