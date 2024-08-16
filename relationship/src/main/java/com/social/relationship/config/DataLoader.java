package com.social.relationship.config;

import com.social.relationship.service.contract.ProfileService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProfileService profileService) {
        return args -> {
            profileService.createProfile("1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032");
            profileService.createProfile("771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551");
            profileService.createProfile("788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627");
            profileService.createProfile("d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8");

            profileService.createFriendship("1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032", "771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551");
            profileService.createFriendship("1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032", "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627");
            profileService.createFriendship("1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032", "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8");
            profileService.createFriendship("771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551", "788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627");
            profileService.createFriendship("771fda51cc819105d8f3ce802fce2a4f33d23054c5a102f19872fad2a3208551", "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8");
            profileService.createFriendship("788176f5bb7f654863c2f3aa6bfaa8b49f54d0288019e9d846f772467984b627", "d52ae056d5830fe0a58a7da85465d6561bb0b9aba01706f010c585810b8fd3c8");

            profileService.createProfile("8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f");
            profileService.createProfile("c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85");
            profileService.createFriendship("8a27182c66548a4dcdc9b0cbf26227defcc076a464faa6b66e9f1c876590c94f", "c5f825c26e2edad6bedd8c23b5da3006638793c4a38faaa6bd49cfbe4ab6dd85");

            profileService.createProfile("519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71");
            profileService.createProfile("a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6");
            profileService.createProfile("31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93");

            profileService.createFriendshipRequest("519ba91a5a5b4afb9dc66f8805ce8c442b6576316c19c6896af2fa9bda6aff71", "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032");
            profileService.createFriendshipRequest("a4fe133a6f4bc82ab1e102ba5bdc6aaa66b3e69bbfd6e64ac30ebf7708e8bff6", "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032");
            profileService.createFriendshipRequest("31cae906048ac3f9dcd9525d0db54d766ffeca05e3c6f87e92f96306b8122d93", "1567b3cb857f132473d4907fd3fee2f96e661308826522e823f5f2e6e20b6032");

            profileService.createProfile("67c80c58573c12562067629782b72c455fbd8ab06bbf8dfbd4bc20331d1cbedf");
            profileService.createProfile("41d52bee906b4347466558329fb7a6cbc24b5ab0a5f6c58e2e614decc764fab3");
            profileService.createProfile("cda07e665379ec023b0577605bfd6f91770fe997d72b4e7d3b90e17c29a1ad9e");
        };
    }
}
