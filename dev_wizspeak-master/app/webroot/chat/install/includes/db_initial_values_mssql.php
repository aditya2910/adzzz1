<?php

	/*
	|| #################################################################### ||
	|| #                             ArrowChat                            # ||
	|| # ---------------------------------------------------------------- # ||
	|| #    Copyright �2010-2012 ArrowSuites LLC. All Rights Reserved.    # ||
	|| # This file may not be redistributed in whole or significant part. # ||
	|| # ---------------- ARROWCHAT IS NOT FREE SOFTWARE ---------------- # ||
	|| #   http://www.arrowchat.com | http://www.arrowchat.com/license/   # ||
	|| #################################################################### ||
	*/

	// The intial configuration settings for ArrowChat
	
	$sql_ary = array(
		"INSERT INTO arrowchat_themes (folder, [name], active, update_link, version, [default]) 
			VALUES ('new_facebook_full', 'New Facebook Full', '1' ,'http://www.arrowchat.com/updatecheck.php?id=8', '5.3', '1')",

		"INSERT INTO arrowchat_smilies ([name], code) 
			VALUES ('smile', ':)'), ('big_grin', ':D'), ('wink', ';)'), ('agape', ':o'), ('bored', ':|'), ('crying', ':''('), ('tongue', ':p'), ('confused', ':s'), ('smile', ':-)'), ('frown', ':-('), ('wink', ';-)'), ('agape', ':-o'), ('bored', ':-|'), ('tongue', ':-p'), ('confused', ':-s'), ('mad', '>:('), ('dead', 'X('), ('delicious', '[delicious]'), ('dont_cry', '[dontcry]'), ('evil', '[evil]'), ('evil_grin', '[evilgrin]'), ('impatient', '[impatient]'), ('inlove', '<3'), ('kiss', ':-*'), ('nerdy', '[nerd]'), ('not_even', '[noteven]'), ('oh_rly', '[ohrly]'), ('shocked', '[shocked]'), ('sick', '[sick]'), ('sing', '[sing]'), ('stress', '[stress]'), ('sunglasses_1', '8)'), ('whistle', '[whistle]'), ('yawn', '[yawn]'), ('zipped', ':X'), ('frown', ':(')",
			
		"INSERT INTO arrowchat_notifications_markup ([name], [type], markup) 
			VALUES ('Private Messages', 1, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_message_icon.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has sent you a new message.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Friend Requests', 2, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_friend_icon.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has sent you a friend request.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Wall Post', 3, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_wall_post.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has wrote on your wall.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Event Invite', 4, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_event.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has invited you to an event.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Group Invite', 5, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_group.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has invited you to a group.<br />	<div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Birthday', 6, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_birthday.png\" class=\"arrowchat_notification_icon\" />It is <a href=\"#\">{author_name}</a>s birthday!<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Comment', 7, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_comment.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has left you a comment.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Reply', 8, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_reply.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has replied to you.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Like Post', 9, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_like.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has liked your post.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Like Comment', 10, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_like.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has liked your comment.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>'), ('Like Photo', 11, '<div class=\"arrowchat_notification_box arrowchat_blue_link\"><img src=\"".$_SESSION['config_path']."themes/new_facebook_full/images/icons/notification_like.png\" class=\"arrowchat_notification_icon\" /><a href=\"#\">{author_name}</a> has liked your photo.<br /><div class=\"arrowchat_received\">Received {longago}</div></div><div class=\"arrowchat_notifications_divider\"></div>')",

		"INSERT INTO arrowchat_config (config_name, config_value, is_dynamic) 
			VALUES ('theme', 'new_facebook_full', 0), ('base_url', '".$_SESSION['config_path']."', 0), ('online_timeout', '120', 0), ('disable_smilies', '0', 0), ('auto_popup_chatbox', '1', 0), ('heart_beat', '3', 0), ('language', 'en', 0), ('idle_time', '3', 0), ('install_time', '".time()."', 0), ('chatrooms_on', '0', 0), ('notifications_on', '0', 0), ('hide_bar_on', '1', 0), ('applications_on', '0', 0), ('popout_chat_on', '1', 0), ('theme_change_on', '0', 0), ('disable_avatars', '0', 0), ('disable_buddy_list', '".$disable_buddy_list."', 0), ('search_number', '10', 0), ('chat_maintenance', '0', 0), ('announcement', '', 0), ('admin_chat_all', '0', 0), ('admin_view_maintenance', '0', 0), ('user_chatrooms', '0', 0), ('user_chatrooms_flood', '10', 0), ('user_chatrooms_length', '30', 0), ('video_chat', '1', 0), ('us_time', '1', 0), ('file_transfer_on', '0', 0), ('width_applications', '16', 0), ('width_buddy_list', '189', 0), ('width_chatrooms', '16', 0), ('buddy_list_heart_beat', '60', 0), ('applications_guests', '1', 0), ('bar_fixed', '0', 0), ('bar_fixed_alignment', 'center', 0), ('bar_fixed_width', '900', 0), ('bar_padding', '15', 0), ('chatroom_auto_join', '0', 0), ('chatroom_history_length', '60', 0), ('disable_arrowchat', '0', 0), ('enable_mobile', '0', 0), ('guests_can_chat', '".$guests_can_chat."', 0), ('guests_can_view', '".$guests_can_view."', 0), ('guests_chat_with', '1', 0), ('push_on', '".$push_on."', 0), ('push_publish', '".$_SESSION['publish_key']."', 0), ('push_subscribe', '".$_SESSION['subscribe_key']."', 0), ('show_full_username', '0', 0), ('users_chat_with', '3', 0), ('hide_admins_buddylist', '0', 0), ('show_bar_links_right', '0', 0), ('enable_chat_animations', '1', 0), ('hide_applications_menu', '0', 0), ('guest_name_change', '1', '0'), ('guest_name_duplicates', '0', '0'), ('guest_name_bad_words', 'fuck,cunt,nigger,shit,admin,administrator,mod,moderator,support', '0'), ('blocked_words', 'fuck,[shit],nigger,[cunt],[ass],asshole', '0'), ('login_url', '', '0'), ('admin_background_color', '', '0'), ('admin_text_color', '', '0'), ('desktop_notifications', '0', '0'), ('facebook_app_id', '', '0'), ('max_upload_size', '5', '0'), ('enable_moderation', '0', '0'), ('chatroom_transfer_on', '0', '0'), ('chatroom_message_length', '150', '0'), ('push_ssl', '0', '0'), ('window_top_padding', '70', '0'), ('video_chat_selection', '1', '0'), ('video_chat_width', '900', '0'), ('video_chat_height', '600', '0'), ('tokbox_api', '', '0'), ('tokbox_secret', '', '0'), ('chatroom_default_names', '0', '0'), ('group_disable_arrowchat', '', '0'), ('group_disable_video', '', '0'), ('group_disable_apps', '', '0'), ('group_disable_rooms', '', '0'), ('group_disable_uploads', '', '0'), ('group_disable_sending_private', '', '0'), ('group_disable_sending_rooms', '', '0')",
			
		"INSERT INTO arrowchat_admin (username, password, email) 
			VALUES ('".$_SESSION['admin_username']."', '".md5($_SESSION['admin_password'])."', '".$_SESSION['admin_email']."')"
	);
?>