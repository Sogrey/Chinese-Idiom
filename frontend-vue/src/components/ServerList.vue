<template>
  <div class="serverList">
    <ul class="scrollModeBox" :style="{'-webkit-overflow-scrolling': scrollMode,height: wrapperHeight + 'px'}">
      <mt-loadmore :top-method="loadTop" :bottom-method="loadBottom" :auto-fill="false" :bottom-all-loaded="allLoaded" ref="loadmore" @top-status-change="handleTopChange" @bottom-status-change="handleBottomChange">
        <li class="bbb" v-for="item in playList" :key="item.index" @click="toRepairDetails(item.pkBill)">
          <p class="content">{{item.content}}</p>
          <p class="time">上报日期：{{item.submitTime}}</p>
          <p class="status red" v-if="item.billState === 'UNTREATED'">{{item.billStateValue}}</p>
          <p class="status orange" v-if="item.billState === 'IN_PROGRESS'">{{item.billStateValue}}</p>
          <p class="status orange" v-if="item.billState === 'SERVICE_COMPLETED'">{{item.billStateValue}}</p>
          <p class="status blue2" v-if="item.billState === 'RETURN_VISIT_COMPLETED'">{{item.billStateValue}}</p>
        </li>

        <div slot="top" class="mint-loadmore-top" style="text-align:center">
          <span v-show="topStatus !== 'loading'" :class="{ 'is-rotate': topStatus === 'drop' }">↓</span>
          <!--<mt-spinner v-show="topStatus == 'loading'" color="#26a2ff"></mt-spinner>-->
          <span class="mint-loadmore-text">{{ topText }}</span>
        </div>
        <div slot="bottom" class="mint-loadmore-bottom">
          <span v-show="bottomStatus !== 'loading'" :class="{ 'is-rotate': bottomStatus === 'drop' }">↑</span>
          <!--<mt-spinner v-show="bottomStatus == 'loading'" color="#26a2ff"></mt-spinner>-->
          <span class="mint-loadmore-text">{{ bottomText }}</span>
        </div>
      </mt-loadmore>
    </ul>

  </div>
</template>
<script>
export default {
  data() {
    return {
      playList: [],
      pageNum: 1,
      pageSize: 4,
      topStatus: '',
      bottomStatus: '',//底部上拉加载状态
      allLoaded: false,
      scrollMode: 'auto',
      haveMore: true,
      // 下拉刷新
      topText: '',
      topPullText: '下拉刷新',
      topDropText: '释放更新',
      topLoadingText: '加载中...',
      bottomText: '',
      bottomPullText: '上拉刷新',
      bottomDropText: '释放更新',
      bottomLoadingText: '加载中...',
      wrapperHeight: 0,//容器高度

    }
  },
  mounted() {
    //获取屏幕宽度
    this.wrapperHeight = document.documentElement.clientHeight;
    // 报修记录
    let vm = this;
    vm.toServerList();
  },
  watch: {
    topStatus(val) {
      switch (val) {
        case 'pull':
          this.topText = this.topPullText;
          break;
        case 'drop':
          this.topText = this.topDropText;
          break;
        case 'loading':
          this.topText = this.topLoadingText;
          break;
      }
    },
    bottomStatus(val) {
      switch (val) {
        case 'pull':
          this.bottomText = this.bottomPullText;
          break;
        case 'drop':
          this.bottomText = this.bottomDropText;
          break;
        case 'loading':
          this.bottomText = this.bottomLoadingText;
          break;
      }
    }
  },
  methods: {
    toServerList() {//跳转到投诉页面。
      const _this = this;
      _this.$Indicator.open({
        text: '加载中',
        spinnerType: 'fading-circle'
      });
      _this.postRequest('', {
        pageNum: _this.pageNum,
        pageSize: _this.pageSize,
      }, function (data) {
        _this.$Indicator.close();
        if (data) {
          _this.playList = data.datas;
          // 判断上拉刷新，下拉加载.
          if (_this.pageNum < data.pages) {
            // 当页面相同时，最后一页弹窗提示。
            _this.haveMore = true;
            _this.pageNum = data.pageNum;
          } else {
            _this.haveMore = false;
          }
          if (_this.pageNum > 1) {
            _this.isHaveMore(_this.haveMore)
          }
          _this.$nextTick(function () {
            _this.scrollMode = 'touch';
          })
        } else {           // 此处需要加一个全局的类名，修改Toast 否则可能会报错
          _this.$Toast({
            message: '暂无记录',
            duration: 2000,
            className: 'noticeErrorToast'
          });
        }

      })
      setTimeout(function () {
        _this.$Indicator.close();
      }, 5000);

    },
    handleTopChange(status) {
      this.topStatus = status;
    },
    handleBottomChange(status) {
      this.bottomStatus = status;
    },
    loadTop() {
      // 下拉刷新数据
      this.handleTopChange("loading");//下拉时 改变状态码
      this.pageNum = 1;
      this.allLoaded = false;//下拉刷新时解除上拉加载的禁用
      // 查询数据
      this.toServerList();
      this.$refs.loadmore.onTopLoaded();
    },
    loadBottom() {
      // 上拉加载
      this.more();
      this.allLoaded = true;
      this.handleBottomChange("loadingEnd");//数据加载完毕 修改状态码
      this.$refs.loadmore.onBottomLoaded();
    },
    more() {
      const _this = this;
      _this.handleBottomChange("loading");//上拉时 改变状态码
      _this.pageNum = parseInt(_this.pageNum) + 1;
      console.log(this.pageNum, '1111')
      this.toServerList();
    },
    isHaveMore(isHaveMore) {
      this.allLoaded = true; // true 是禁止上拉加载；
      if (isHaveMore) {
        //isHaveMore 为true 有下一页，不禁止上拉
        this.allLoaded = false
      } else {
        //false 没有下一页，禁止下拉，默认为true
        this.$Toast({
          message: '没有更多了',
          duration: 2000,
          className: 'noticeErrorToast'
        });
        this.allLoaded = true;
        return;
      }
    },
    toRepairDetails(id) {
      this.$router.push({
        path: '/complaindetails',
        query: { id: id }
      })
    }
  }
}
</script>
<style scoped>
/*状态的判断*/
.red {
  color: red;
}

.orange {
  color: #f69203;
}

.blue2 {
  color: #0585c8;
}

.yellow {
  color: yellow;
}

.current {
  background-color: #fff;
  color: #0585c8;
}

.serverList {
  width: 100%;
  /* height: 100%; */
  background-color: #f2f2f2;
  padding-bottom: 20px;
}

.serverList ul {
  padding-top: 10px;
}

.serverList ul li {
  box-sizing: border-box;
  background-color: #fff;
  margin: 40px 26px 0 26px;
  border-radius: 10px;
  padding: 34px 23px;
}

/*待处理状态*/
.serverList ul li .status {
  font-size: 28px;
  text-align: right;
  height: 60px;
  line-height: 60px;
  padding-top: 8px;
  box-sizing: border-box;
  padding-right: 20px;
}

/*报修内容*/
.serverList ul li .content {
  font-size: 28px;
  width: 550px;
  color: #333;
  text-align: left;
  margin-left: 30px;
  line-height: 48px;
}

/*上报时间*/
.serverList ul li .time {
  text-align: left;
  font-size: 24px;
  color: #999;
  margin: 10px 0 0 30px;
  padding-bottom: 20px;
}

.load-more-normal {
  text-align: center;
  line-height: 60px;
}

.load-more-hide {
  height: 0;
}
</style>