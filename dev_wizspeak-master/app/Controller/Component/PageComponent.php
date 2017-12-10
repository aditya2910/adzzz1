<?php
App::uses('Component', 'Controller');

class PageComponent extends Component {

			public $components = array('Session');

			public function setPageVariable($wallId,$wallType,$loginId,$vertical){

			$this->Session->write('Page.wallId', $wallId);
			$this->Session->write('Page.wallType', $wallType);
			$this->Session->write('Page.loginId', $loginId);
			$this->Session->write('Page.vertical', $vertical);
debug("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx  update");
			}

			public function getPageVariable(){

				$ret = array(
				"wallId" => $this->Session->read('Page.wallId'),
				"wallType" => $this->Session->read('Page.wallType'),
				"loginId" => $this->Session->read('Page.loginId'),
				"vertical" => $this->Session->read('Page.vertical'),
				);
			return $ret;

			}

        }

?>
