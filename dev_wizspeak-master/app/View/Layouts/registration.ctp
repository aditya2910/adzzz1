<!doctype html>
<!--[if IE 8 ]>    <html lang="en" class="ie ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="ie ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!-->
<html lang="en">
<!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <title></title>
    <meta name="description" content="">
    <meta name="author" content="">
    <meta name="viewport" content="width=device-width,initial-scale=1">
    <?php

    if($this->request->params['action']=='profile_photo'){
    echo $this->Html->script('script');
    echo $this->Html->script('registration/crop/jquery.Jcrop.js');

    }
    echo $this->Html->css('styles');
    echo $this->Html->css('addedstyles');
    echo $this->Html->script('modernizr.custom.56100');
	echo $this->Html->css('registration/reg');
	echo $this->Html->css('crop.css');

    ?>
	<style>
		.add-new-amb{
			display: none;
		}
	</style>

</head>

<body>
    <div class="main-container">
        <div class="header-wrapper2">
            <header class="full-container header">
                <div class="fixed-container">
                    <div class="logo">
                        <a href="#">
                            <?php

                            echo $this->Html->image("logo.png", array(
                            "alt" => "WIZSPEAK",
                            'url' => array('controller' => 'pages', 'action' => 'home')
                            ));
                            ?>

                        </a>

                    </div>
                    <div class="clear"></div>
                </div>
            </header>
        </div>
        <div class="full-container login">
        <!-- Here page fetches Start  -->

        <div id="content">

                        <?php echo $this->Session->flash(); ?>

			<?php echo $this->fetch('content'); ?>
	</div>

        <!-- Here page fetches End    -->


            <footer>
                <ul class="footer_ulist">
                    <li>
                        <a href="#">About</a>
                    </li>
                    <li>
                        <a href="#">Developers</a>
                    </li>
                    <li>
                        <a href="#">Create Page</a>
                    </li>
                    <li>
                        <a href="#">Utility</a>
                    </li>
                    <li>
                        <a href="#">Entertainment</a>
                    </li>
                    <li>
                        <a href="#">Games</a>
                    </li>
                    <li>
                        <a href="#">Privacy</a>
                    </li>
                    <li>
                        <a href="#">Help</a>
                    </li>
                </ul>
                <div class="copyrite">Wizspeak &copy; 2016</div>
            </footer>
        </div>

        <div class="clear"></div>
    </div>
    <?php

    echo $this->Html->script('script');
    echo $this->Html->script('jssor.slider.mini');
    echo $this->Html->script('init');
         echo $this->Html->script('JsFunctions');
         echo $this->Html->script('jquery-ui.js');
         echo $this->Html->script('registration');
	echo $this->Html->script('crop');
	echo $this->Html->script('crop-init');
	echo $this->Html->script('syntaxhighlight');

	//echo $this->Html->script('script');


    ?>


</body>

</html>
