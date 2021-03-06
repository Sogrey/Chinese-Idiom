// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import tween from "./plugins/tween";
import MintUI from 'mint-ui'
import App from './App'
import router from './router'
import 'mint-ui/lib/style.css'

Vue.config.productionTip = false

Vue.use(MintUI)
Vue.use(tween);

/* eslint-disable no-new */
new Vue({
    el: '#app',
    router,
    components: { App },
    template: '<App/>',
    mounted() {
        this.tweenUpdate();
    },
    methods: {
        tweenUpdate() {
            requestAnimationFrame(this.tweenUpdate);
            this.$tweener.update();
        },
    },
})
