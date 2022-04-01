import TWEEN from '@tweenjs/tween.js'

export default {
    install: function (Vue) {
        Vue.prototype.$tween = this;
        Vue.prototype.$tweener = TWEEN;
    },
    pause: function (tw) {
        tw.pause();
    },
    fade: function (target, to, during, options) {
        if (!target || !to) {
            return;
        }
        if (during == null) {
            during = 260;
        }
        if(!options) options = {};
        let tw = new TWEEN.Tween(target).to(to, during);
        tw.delay(options.delay?options.delay:0);
        tw.easing(options.easing || TWEEN.Easing.Linear.None)
        tw.onUpdate(options.onUpdate?options.onUpdate:()=>{});
        tw.onComplete(options.onComplete?options.onComplete:()=>{});
        tw.start();
        return tw;
    },
}
