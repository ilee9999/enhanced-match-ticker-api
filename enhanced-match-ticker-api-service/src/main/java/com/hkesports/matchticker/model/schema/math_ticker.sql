
    alter table ability_upgrades 
        drop constraint FK_rijbkg2d3128p2ai34yddo5j3;

    alter table ability_upgrades 
        drop constraint FK_3vr1ie8dqbglgg9gflbravnxl;

    alter table code 
        drop constraint FK_mrnbwst2qvaw84juvqpsuykd9;

    alter table data 
        drop constraint FK_4evr5ioe12ifsdf51dlg6x4d9;

    alter table data 
        drop constraint FK_a0hcetu6xbo52hcecfw7vm3k9;

    alter table game_picks_bans 
        drop constraint FK_lt291gsjlgb739jd2waiutyb;

    alter table game_picks_bans 
        drop constraint FK_ip4jwb7o5kq322my18tl94d7n;

    alter table live_streams 
        drop constraint FK_mav5lwu96mpmbgtsduf65pcap;

    alter table live_streams 
        drop constraint FK_dp564xy6sq2pkop6xrc7xjoj1;

    alter table schedule 
        drop constraint FK_6nfp4pgp600slo18rrvxhcd6;

    alter table schedule 
        drop constraint FK_20dfnxem5b4vdnv3mrkxth5m4;

    alter table schedule_game 
        drop constraint FK_dimnlsud0v72hbjfl80tdg3f3;

    alter table schedule_game_detail 
        drop constraint FK_g5u272bhuvp9b6ddbuyw19aa0;

    alter table schedule_game_detail 
        drop constraint FK_5erqq8hwt06s8r7tatngb5v9x;

    alter table schedule_game_player_detail 
        drop constraint FK_neh7t60ejsmm227n75xqarks9;

    alter table schedule_game_player_detail 
        drop constraint FK_ml2dyro2h42efqjpuiiwt3jfl;

    alter table schedule_game_player_items 
        drop constraint FK_tictbncg7foobwx7im7q664mk;

    alter table schedule_game_player_items 
        drop constraint FK_r8yf38b3m7qg24wnfpqg0q0if;

    alter table spell_data 
        drop constraint FK_a4d757i56khivrqsrtfekb0lq;

    alter table team_member 
        drop constraint FK_5g0c914cuohcnat68yxga0pn0;

    drop table if exists ability_upgrades cascade;

    drop table if exists code cascade;

    drop table if exists data cascade;

    drop table if exists game cascade;

    drop table if exists game_picks_bans cascade;

    drop table if exists hero cascade;

    drop table if exists item_data cascade;

    drop table if exists job_record cascade;

    drop table if exists live_streams cascade;

    drop table if exists player cascade;

    drop table if exists rune_data cascade;

    drop table if exists schedule cascade;

    drop table if exists schedule_game cascade;

    drop table if exists schedule_game_detail cascade;

    drop table if exists schedule_game_player_detail cascade;

    drop table if exists schedule_game_player_items cascade;

    drop table if exists spell_data cascade;

    drop table if exists team cascade;

    drop table if exists team_member cascade;

    drop table if exists tournament cascade;

    drop sequence hibernate_sequence;

    create table ability_upgrades (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id INT(11),
        level INT(11),
        time INT(11),
        player_id BIGINT(20),
        schedule_game_id BIGINT(20),
        primary key (id)
    );

    create table code (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        code_desc varchar(255),
        key varchar(128) not null,
        published char(1),
        parent_code_id BIGINT(20),
        primary key (id)
    );

    create table data (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        data_desc varchar(255),
        data_name varchar(128) not null,
        data_value varchar(256) not null,
        published char(1),
        code_id BIGINT(20),
        parent_data_id BIGINT(20),
        primary key (id)
    );

    create table game (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
         date_time timestamp,
        draw_score SMALLINT(6) not null,
        en_game_name varchar(100) not null,
        game_icon_large BLOB,
        game_icon_small BLOB,
        game_url varchar(255),
        is_finished varchar(10),
        is_live TINYINT(4),
        lose_score SMALLINT(6) not null,
        max_games SMALLINT(6),
        polldaddy_id varchar(255),
        team TINYINT(4) not null,
        team_a_default_icon_large BLOB,
        team_a_default_icon_small BLOB,
        team_b_default_icon_large BLOB,
        team_b_default_icon_small BLOB,
        tw_game_name varchar(100) not null,
        win_score SMALLINT(6) not null,
        winner_id SMALLINT(6),
        primary key (id)
    );

    create table game_picks_bans (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        game_type varchar(10),
        is_pick TINYINT,
        item_order INT(11),
        team_id BIGINT(20),
        hero_id BIGINT(20),
        schedule_game_id BIGINT(20),
        primary key (id)
    );

    create table hero (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        en_name varchar(50),
        image_full_name varchar(100),
        image_h INT(11),
        image_w INT(11),
        name varchar(50) not null,
        title varchar(255),
        version varchar(20),
        primary key (id)
    );

    create table item_data (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        cost INT(11),
        description TEXT,
        en_name varchar(50),
        expire_date datetime,
        image_full_name varchar(100),
        image_h INT(11),
        image_w INT(11),
        name varchar(255) not null,
        plaintext varchar(255),
        version varchar(20),
        primary key (id)
    );

    create table job_record (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        end_date varchar(20),
        exception_message TEXT,
        execution_time varchar(20),
        name varchar(100) not null,
        start_date varchar(20) not null,
        primary key (id)
    );

    create table live_streams (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        embed_code TEXT,
        language varchar(100),
        type varchar(100),
        url varchar(255),
        schedule_game_id BIGINT(20),
        tournament_id BIGINT(20),
        primary key (id)
    );

    create table player (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        bio TEXT,
        contract_expiration timestamp,
        country varchar(2),
        facebook_url varchar(255),
        hometown varchar(100),
        is_starter SMALLINT(6),
        photo_url varchar(255),
        player_full_name varchar(128),
        player_icon_large BLOB,
        player_icon_small BLOB,
        player_name varchar(128),
        player_url varchar(255),
        residency varchar(255),
        twitter_url varchar(255),
        primary key (id)
    );

    create table rune_data (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        description TEXT,
        image_full_name varchar(100),
        image_h INT(11),
        image_w INT(11),
        is_rune TINYINT(4),
        name varchar(255) not null,
        tier INT(11),
        type varchar(20),
        version varchar(20),
        primary key (id)
    );

    create table schedule (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        a_side_support_count BIGINT(20),
        b_side_support_count BIGINT(20),
        display TINYINT,
        end_time timestamp,
        highlight TINYINT not null,
        is_finished SMALLINT(6),
        match_archive_url varchar(2048),
        match_live_url varchar(2048),
        name varchar(255),
        name_public varchar(255),
        no_vods SMALLINT(6),
        player_a_name varchar(64),
        player_b_name varchar(64),
        published SMALLINT(6),
        results varchar(32),
        season varchar(50),
        start_time timestamp not null,
        team_a_name varchar(50),
        team_b_name varchar(50),
        tournament_name varchar(255),
        winner BIGINT(20),
        game_id BIGINT(20),
        tournament_id BIGINT(20),
        primary key (id)
    );

    create table schedule_game (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        date_time timestamp,
        first_blood_time int4,
        game_length int4,
        game_mode SMALLINT(6),
        game_number SMALLINT(6),
        human_players int4,
        leg_url varchar(255),
        lobby_type SMALLINT(6),
        max_games SMALLINT(6),
        negative_vote int4,
        no_vods SMALLINT(6),
        platform_game_id BIGINT(20),
        platform_id varchar(50),
        positive_votes int4,
        winner_id BIGINT(20),
        schedule_id BIGINT(20),
        primary key (id)
    );

    create table schedule_game_detail (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        baron_kills INT(11),
        barracks_status INT(11),
        dragon_kills INT(11),
        first_baron TINYINT,
        first_blood TINYINT,
        first_dragon TINYINT,
        first_inhibitor TINYINT,
        first_tower TINYINT,
        inhibitor_kills INT(11),
        tower_kills INT(11),
        tower_status INT(11),
        vilemaw_kills INT(11),
        win varchar(5),
        schedule_game_id BIGINT(20),
        team_id BIGINT(20),
        primary key (id)
    );

    create table schedule_game_player_detail (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        assists INT(11),
        combat_player_score INT(11),
        deaths INT(11),
        double_kills INT(11),
        end_level INT(11),
        first_blood_assist TINYINT,
        first_blood_kill TINYINT,
        first_inhibitor_assist TINYINT,
        first_inhibitor_kill TINYINT,
        first_tower_assist TINYINT,
        first_tower_kill TINYINT,
        gold_per_min INT(11),
        gold_spent INT(11),
        hero_damage INT(11),
        hero_healing INT(11),
        inhibitor_kills INT(11),
        kda DOUBLE,
        killing_sprees INT(11),
        kills INT(11),
        lane varchar(255),
        largest_critical_strike INT(11),
        largest_killing_spree INT(11),
        largest_multi_kill INT(11),
        longest_time_spent_living INT(11),
        magic_damage_dealt INT(11),
        magic_damage_dealt_to_champions INT(11),
        magical_damage_taken INT(11),
        minions_killed INT(11),
        neutral_minions_killed INT(11),
        neutral_minions_killed_enemy_jungle INT(11),
        neutral_minions_killed_team_jungle INT(11),
        objective_player_score INT(11),
        penta_kills INT(11),
        physical_damage_dealt INT(11),
        physical_damage_dealt_to_champions INT(11),
        physical_damage_taken INT(11),
        player_slot INT(11),
        quadra_kills INT(11),
        role varchar(255),
        sight_wards_bought_in_game INT(11),
        total_damage_dealt INT(11),
        total_damage_dealt_to_champions INT(11),
        total_damage_taken INT(11),
        total_gold INT(11),
        total_heal INT(11),
        total_player_score INT(11),
        total_score_rank INT(11),
        total_time_crowd_control_dealt INT(11),
        total_units_healed INT(11),
        tower_damage INT(11),
        triple_kills INT(11),
        true_damage_dealt INT(11),
        true_damage_dealt_to_champions INT(11),
        true_damage_taken INT(11),
        turret_kills INT(11),
        unreal_kills INT(11),
        vision_wards_bought_in_game INT(11),
        wards_killed INT(11),
        wards_placed INT(11),
        xp_per_min INT(11),
        player_id BIGINT(20) not null,
        schedule_game_id BIGINT(20) not null,
        primary key (id)
    );

    create table schedule_game_player_items (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        item_id BIGINT(20),
        item_type varchar(10),
        sequence SMALLINT(6),
        player_id BIGINT(20),
        schedule_game_id BIGINT(20),
        primary key (id)
    );

    create table spell_data (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        description TEXT,
        en_name varchar(255) not null,
        expire_date datetime,
        image_full_name varchar(100),
        image_h INT(11),
        image_w INT(11),
        name varchar(255) not null,
        summoner_level INT(11),
        version varchar(20),
        hero_id BIGINT(20),
        primary key (id)
    );

    create table team (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        bio TEXT,
        country varchar(2),
        logo_url varchar(255),
        no_players SMALLINT(6),
        rating varchar(255),
        team_full_name varchar(128),
        team_icon_large BLOB,
        team_icon_small BLOB,
        team_name varchar(128),
        team_photo_url varchar(255),
        team_url varchar(255),
        primary key (id)
    );

    create table team_member (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        is_starter SMALLINT(6),
        member_country varchar(2),
        member_full_Name varchar(128),
        member_icon_large BLOB,
        member_icon_small BLOB,
        member_name varchar(128),
        role varchar(255),
        team_url varchar(255),
        team_id BIGINT(20),
        primary key (id)
    );

    create table tournament (
        id BIGINT(20) not null,
        create_date timestamp,
        update_date timestamp,
        api_id BIGINT(20),
        game_type varchar(10),
        color varchar(7),
        default_schedule_id BIGINT(20),
        draw_score SMALLINT(6) not null,
        league_image varchar(255),
        lose_score SMALLINT(6) not null,
        menu_weight INT(11),
        no_vods SMALLINT(6),
        published SMALLINT(6),
        tournament_channel_url varchar(255),
        tournament_description TEXT,
        tournament_from_date timestamp,
        tournament_icon_Huge BLOB,
        tournament_icon_large BLOB,
        tournament_icon_small BLOB,
        tournament_Name varchar(255) not null,
        tournament_short_name varchar(100) not null,
        tournament_site_url varchar(255) not null,
        tournament_to_date timestamp,
        win_score SMALLINT(6) not null,
        primary key (id)
    );

    alter table ability_upgrades 
        add constraint FK_rijbkg2d3128p2ai34yddo5j3 
        foreign key (player_id) 
        references player;

    alter table ability_upgrades 
        add constraint FK_3vr1ie8dqbglgg9gflbravnxl 
        foreign key (schedule_game_id) 
        references schedule_game;

    alter table code 
        add constraint FK_mrnbwst2qvaw84juvqpsuykd9 
        foreign key (parent_code_id) 
        references code;

    alter table data 
        add constraint FK_4evr5ioe12ifsdf51dlg6x4d9 
        foreign key (code_id) 
        references code;

    alter table data 
        add constraint FK_a0hcetu6xbo52hcecfw7vm3k9 
        foreign key (parent_data_id) 
        references data;

    alter table game_picks_bans 
        add constraint FK_lt291gsjlgb739jd2waiutyb 
        foreign key (hero_id) 
        references hero;

    alter table game_picks_bans 
        add constraint FK_ip4jwb7o5kq322my18tl94d7n 
        foreign key (schedule_game_id) 
        references schedule_game;

    alter table live_streams 
        add constraint FK_mav5lwu96mpmbgtsduf65pcap 
        foreign key (schedule_game_id) 
        references schedule_game;

    alter table live_streams 
        add constraint FK_dp564xy6sq2pkop6xrc7xjoj1 
        foreign key (tournament_id) 
        references tournament;

    alter table schedule 
        add constraint FK_6nfp4pgp600slo18rrvxhcd6 
        foreign key (game_id) 
        references game;

    alter table schedule 
        add constraint FK_20dfnxem5b4vdnv3mrkxth5m4 
        foreign key (tournament_id) 
        references tournament;

    alter table schedule_game 
        add constraint FK_dimnlsud0v72hbjfl80tdg3f3 
        foreign key (schedule_id) 
        references schedule;

    alter table schedule_game_detail 
        add constraint FK_g5u272bhuvp9b6ddbuyw19aa0 
        foreign key (schedule_game_id) 
        references schedule_game;

    alter table schedule_game_detail 
        add constraint FK_5erqq8hwt06s8r7tatngb5v9x 
        foreign key (team_id) 
        references team;

    alter table schedule_game_player_detail 
        add constraint FK_neh7t60ejsmm227n75xqarks9 
        foreign key (player_id) 
        references player;

    alter table schedule_game_player_detail 
        add constraint FK_ml2dyro2h42efqjpuiiwt3jfl 
        foreign key (schedule_game_id) 
        references schedule_game;

    alter table schedule_game_player_items 
        add constraint FK_tictbncg7foobwx7im7q664mk 
        foreign key (player_id) 
        references player;

    alter table schedule_game_player_items 
        add constraint FK_r8yf38b3m7qg24wnfpqg0q0if 
        foreign key (schedule_game_id) 
        references schedule_game;

    alter table spell_data 
        add constraint FK_a4d757i56khivrqsrtfekb0lq 
        foreign key (hero_id) 
        references hero;

    alter table team_member 
        add constraint FK_5g0c914cuohcnat68yxga0pn0 
        foreign key (team_id) 
        references team;

    create sequence hibernate_sequence;
