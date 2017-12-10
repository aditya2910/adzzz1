<?php
/**
 * This file is loaded automatically by the app/webroot/index.php file after core.php
 *
 * This file should load/create any application wide configuration settings, such as
 * Caching, Logging, loading additional configuration files.
 *
 * You should also use this file to include any files that provide global functions/constants
 * that your application uses.
 *
 * @link          http://cakephp.org CakePHP(tm) Project
 * @package       app.Config
 * @since         CakePHP(tm) v 0.10.8.2117
 */

// Setup a 'default' cache configuration for use in the application.
Cache::config('default', array('engine' => 'File'));

/**
 * The settings below can be used to set additional paths to models, views and controllers.
 *
 * App::build(array(
 *     'Model'                     => array('/path/to/models/', '/next/path/to/models/'),
 *     'Model/Behavior'            => array('/path/to/behaviors/', '/next/path/to/behaviors/'),
 *     'Model/Datasource'          => array('/path/to/datasources/', '/next/path/to/datasources/'),
 *     'Model/Datasource/Database' => array('/path/to/databases/', '/next/path/to/database/'),
 *     'Model/Datasource/Session'  => array('/path/to/sessions/', '/next/path/to/sessions/'),
 *     'Controller'                => array('/path/to/controllers/', '/next/path/to/controllers/'),
 *     'Controller/Component'      => array('/path/to/components/', '/next/path/to/components/'),
 *     'Controller/Component/Auth' => array('/path/to/auths/', '/next/path/to/auths/'),
 *     'Controller/Component/Acl'  => array('/path/to/acls/', '/next/path/to/acls/'),
 *     'View'                      => array('/path/to/views/', '/next/path/to/views/'),
 *     'View/Helper'               => array('/path/to/helpers/', '/next/path/to/helpers/'),
 *     'Console'                   => array('/path/to/consoles/', '/next/path/to/consoles/'),
 *     'Console/Command'           => array('/path/to/commands/', '/next/path/to/commands/'),
 *     'Console/Command/Task'      => array('/path/to/tasks/', '/next/path/to/tasks/'),
 *     'Lib'                       => array('/path/to/libs/', '/next/path/to/libs/'),
 *     'Locale'                    => array('/path/to/locales/', '/next/path/to/locales/'),
 *     'Vendor'                    => array('/path/to/vendors/', '/next/path/to/vendors/'),
 *     'Plugin'                    => array('/path/to/plugins/', '/next/path/to/plugins/'),
 * ));
 *
 */

/**
 * Custom Inflector rules can be set to correctly pluralize or singularize table, model, controller names or whatever other
 * string is passed to the inflection functions
 *
 * Inflector::rules('singular', array('rules' => array(), 'irregular' => array(), 'uninflected' => array()));
 * Inflector::rules('plural', array('rules' => array(), 'irregular' => array(), 'uninflected' => array()));
 *
 */

/**
 * Plugins need to be loaded manually, you can either load them one by one or all of them in a single call
 * Uncomment one of the lines below, as you need. Make sure you read the documentation on CakePlugin to use more
 * advanced ways of loading plugins
 *
 * CakePlugin::loadAll(); // Loads all plugins at once
 * CakePlugin::load('DebugKit'); //Loads a single plugin named DebugKit
 *
 */

/**
 * You can attach event listeners to the request lifecycle as Dispatcher Filter . By default CakePHP bundles two filters:
 *
 * - AssetDispatcher filter will serve your asset files (css, images, js, etc) from your themes and plugins
 * - CacheDispatcher filter will read the Cache.check configure variable and try to serve cached content generated from controllers
 *
 * Feel free to remove or add filters as you see fit for your application. A few examples:
 *
 * Configure::write('Dispatcher.filters', array(
 *		'MyCacheFilter', //  will use MyCacheFilter class from the Routing/Filter package in your app.
 *		'MyPlugin.MyFilter', // will use MyFilter class from the Routing/Filter package in MyPlugin plugin.
 * 		array('callable' => $aFunction, 'on' => 'before', 'priority' => 9), // A valid PHP callback type to be called on beforeDispatch
 *		array('callable' => $anotherMethod, 'on' => 'after'), // A valid PHP callback type to be called on afterDispatch
 *
 * ));
 */
Configure::write('Dispatcher.filters', array(
	'AssetDispatcher',
	'CacheDispatcher'
));

/**
 * Configures default file logging options
 */
App::uses('CakeLog', 'Log');
CakeLog::config('debug', array(
	'engine' => 'File',
	'types' => array('notice', 'info', 'debug'),
	'file' => 'debug',
));
CakeLog::config('error', array(
	'engine' => 'File',
	'types' => array('warning', 'error', 'critical', 'alert', 'emergency'),
	'file' => 'error',
));


define('MY_APP','wizspeak');
define('APPURL','http://wizspeak.com/wizspeak/');

define('PROFILE_IMAGE_PATH','user/profile_photo/');
define('PROFILE_IMAGE_PATH_FINAL','user/profile_photo/user_pic/');
define('PROFILE_IMAGE_MEDIUM',250);
define('PROFILE_IMAGE_SMALL',100);
define('GROUP_COVER_PIC','upload/group/cover_pic/');

define('FFMPEG_VIDEO_NORMAL_SIZE','720x576');

define('POST_IMAGE_UPLOAD_FOLDER','upload/images/');

define('POST_VIDEO_PROCESS_FOLDER','upload/videos/');

define('POST_VIDEO_FOLDER','upload/videos/processed/');
define('POST_VIDEO_THUMBNAIL_UPLOAD_FOLDER','upload/videos/thumb/');


define('POST_DOC_UPLOAD_FOLDER','upload/documents/');

define('POST_AUDIO_UPLOAD_FOLDER','upload/audio/');

define('POST_AUDIO_FOLDER','upload/audio/processed/');

define('FFMPEG_PATH','C:\\FFMPEG\\bin\\FFMPEG');

define('IMAGE_WALL_DESK','http://139.162.37.75/images/530x1000/');
define('IMAGE_FULL_WALL_DESK','http://139.162.37.75/images/700x1000/');
define('IMAGE_CHANGE','http://139.162.37.75/images/250x250/');
define('IMAGE_PROFILE_MAIN','http://139.162.37.75/images/90x90/');
define('IMAGE_PROFILE_AMB','http://139.162.37.75/images/100x100/');
define('IMAGE_PROFILE_WALL','http://139.162.37.75/images/50x50/');
define('IMAGE_PROFILE_WALL_COMMENT','http://139.162.37.75/images/40x40/');
define('IMAGE_PROFILE_BIG','http://139.162.37.75/images/320x320/');
define('VIDEO_THUMB','https://i.ytimg.com/vi/');

//........creativity upload..........//


/** Upload Dir creativity **/
define('CRE_IMAGE_UPLOAD_FOLDER','upload/creativity/photo/');
define('CRE_VIDEO_UPLOAD_FOLDER','upload/creativity/video/mp4/');
define('CRE_VIDEO_THUMBNAIL_UPLOAD_FOLDER','upload/creativity/video/thumb/');
define('CRE_VIDEO_PROCESS_FOLDER','upload/creativity/video/process/');
define('CRE_AUDIO_UPLOAD_FOLDER','upload/creativity/audio/mp3/');
define('CRE_AUDIO_PROCESS_FOLDER','upload/creativity/audio/process/');
define('CRE_DOC_FOLDER','upload/creativity/doc/');


define('IMAGE_CRE_THUMB','http://139.162.37.75/images/400x300/');
define('IMAGE_CRE_POPUP','http://139.162.37.75/images/660x495/');
define('IMAGE_COVER_PIC','http://139.162.37.75/images/960x380/');
define('IMAGE_PRO_THUMB','http://139.162.37.75/images/400x400/');
/** END Upload Dir creativity***/

define('COVERPIC_UPLOAD_FOLDER','upload/images/coverpic/');

//ad remove

define('ADDS',true);

define('HOME_URL','ambitions');



CakePlugin::load('Opauth', array('routes' => true, 'bootstrap' => true));

Configure::write('Opauth.path', '/wizspeak/auth/');


spl_autoload_unregister(array('App', 'load'));

spl_autoload_register(array('App', 'load'), true, true);


//  Facebook Outh

Configure::write('Opauth.Strategy.Facebook', array(
	'app_id' => '1004411736301156',
	'app_secret' => 'a800400af01add3c8a88acbc015a8072'
));

//  Google Outh
Configure::write('Opauth.Strategy.Google', array(

	'client_id' => '529155930764-5tlfv11bbglog556udetto20veh7evj3.apps.googleusercontent.com',
	'client_secret' => 'phvzGzg4_cGu56vBx1U1b9au'
));


//  Twitter Outh
Configure::write('Opauth.Strategy.Twitter', array(
	'key' => 'QN8NrLxrA9tSML4ik4X99V1Tw',
	'secret' => '9Yg5Tku69XOMgfyuH5WxFJLLDgfL1rJlkZ86mkozOQULTJhOHg'
));

//  Linkdin Outh
Configure::write('Opauth.Strategy.Linkedin', array(
	'api_key' => '755o1xf5xk64c4',
	'secret_key' => 'e0kOGzq8xtvZtRPs'
));
