from main.http_poster import HttpPoster
from tujia.tujia_env import TujiaEnv

# TODO: 3.add exception support

if __name__ == "__main__":
    env = TujiaEnv(TujiaEnv.FVT)
    url = 'https://merchant.fvt.tujia.com/StoreApply/SimulateLogin?groupMerchantGlobalID=5ae93366-b5e0-49fe-a0ed' \
          '-ab87d9804030&merchantGlobalID=1ec81178-a3e9-4135-8df7-b53954967b8e&url=https%3A%2F%2Fmerchantcrm.fvt' \
          '.tujia.com%2Fmerchant-web%2Funit%2Fedithouseposition%3FhouseUnitId%3D591a9eeac004eb130ce5378f '

    url = ''

    HttpPoster.post(url, headers=env.get_headers())
