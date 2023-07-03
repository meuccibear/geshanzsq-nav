<template>
  <el-tooltip
    :content="site.siteDescription"
    :visible-arrow="false"
    :disabled="
      site.siteDescription == undefined ||
      site.siteDescription === '' ||
      disabledTip ||
      !showSiteDescription
    "
    placement="bottom"
    effect="light"
  >
    <el-card shadow="hover" class="site-card" @click="handleSiteCard">
      <el-container>
        <el-aside class="site-card-aside">
          <el-image
            loading="lazy"
            class="site-card-logo"
            :src="getPictureShowUrl(site.sitePath)"
          >
            <template #error>
              <el-image
                loading="lazy"
                class="site-card-logo"
                :src="getPictureShowUrl(defaultSiteImage)"
              />
            </template>
          </el-image>
        </el-aside>
        <el-main class="site-card-main">
          <a
            class="site-title"
            :class="showSiteDescription ? '' : 'site-title-no-description'"
            ><strong>{{ site.siteName }}</strong></a
          >
          <div class="site-description" v-if="showSiteDescription">
            {{ site.siteDescription }}
          </div>
        </el-main>
        <el-divider direction="vertical" style="height: 4rem;"></el-divider>
        <el-main class="site-card-main2">
          <div class="site-title-two" >
            评分：<span style="color: #67c23a"><strong>{{ site.score}}</strong></span>
          </div>
          <div class="site-title-two">
            费用: <span>{{ ''+ (site.free == 1 ? '免费':'收费') }}</span>
          </div>
          <div class="site-title-two">
            合理性: <span>{{(site.reasonable == 1 ? '':'不') + '合理' }}</span>
          </div>
        </el-main>
        <slot name="container-footer"></slot>
      </el-container>
      <slot name="card-footer"></slot>
    </el-card>
  </el-tooltip>
</template>
<script setup>
import { computed, ref } from 'vue'
import { useStore } from 'vuex'

import { updateClickCount } from '@/api/nav/site'
import { openSite } from '@/utils/geshanzsq'
const props = defineProps({
  // 网站信息
  site: {
    type: Object
  },
  // 改变标题颜色
  changeTitleColor: {
    type: Boolean,
    default: true
  },
  // 是否打开网站
  openSite: {
    type: Boolean,
    default: true
  },
  // 是否开启描述提示
  disabledTip: {
    type: Boolean,
    default: true
  }
})

const store = useStore()

// 默认图片
const defaultSiteImage = ref('/profile/site/system/logo.jpg')
const showSiteDescription = computed(
  () => store.getters['settings/showSiteDescription']
)

/**
 * 网站卡片点击事件
 */
function handleSiteCard() {
  if (!props.openSite) {
    return
  }
  openSite(props.site.siteUrl)
  updateClickCount(props.site.id)
}
</script>
<style lang="scss" scoped>
.site-card {
  cursor: pointer;
  .site-card-aside {
    background-color: transparent;
    width: 40px;
    overflow: hidden;
    padding: 0px;
    margin: 0px;
    text-align: center;
    .site-card-logo {
      border-radius: 50%;
      width: 40px;
      height: 40px;
    }
  }
  .site-card-main {
    padding: 0;
    margin-left: 5px;
    width: 48%;
    .site-title {
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 1;
      overflow: hidden;
      font-size: 15px;
      color: #373e4a;
    }
    .site-title-no-description {
      padding-top: 10px;
    }
    .site-description {
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 2;
      overflow: hidden;
      margin-top: 5px;
      font-size: 12px;
      //height: 39px;
      color: #979898;
    }
  }

  .site-card-main2 {
    margin: 0px;
    padding: 0;
    .site-title-two {
      display: -webkit-box;
      -webkit-box-orient: vertical;
      -webkit-line-clamp: 1;
      overflow: hidden;
      font-size: 12px;
      color: #373e4a;
      padding-bottom: 5px;
    }
  }
}
</style>
