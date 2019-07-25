var vm02 = new Vue({
		el : '#xinxi',
		data : {
			showa : false,
			showb : false,
			showc : false
		},
		methods : {
			a : function() {
				this.showa = !this.showa;
			},
			b : function() {
				this.showb = !this.showb;
			},
			c : function() {
				this.showc = !this.showc;
			}
		}
	});