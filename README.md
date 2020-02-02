
# HexAlertDialog
HexAlertDialog is an alert dialog library that will help you to create almost fully customized alert dialogs.

![HexAlertDialog](https://i.hizliresim.com/OrWNMP.jpg)

## Set Up
```
implementation 'com.ercan.hexalertdialog:hexalertdialog:1.2'
implementation 'androidx.cardview:cardview:1.0.0'
```
## Use

```
HexAlertDialog(this).apply {
    title = "Title"
    titleColor = Color.parseColor("#000000")
    titleBackgroundColor = Color.parseColor("#FFFFFF")
    message = "This is the message."
    positiveBtnTextColor = Color.parseColor("#F05400")
    positiveBtnClickListener = {
      
    }
    negativeBtnClickListener = {
      
    }	
}
```

## Attributes

|  Attribute | Type | Description | Example of Use | Tip/ Warning  |
| ------------ | ------------ | ------------  | ------------  | ------------  |
| title      |  String  |  The title of the dialog  | "Title" | -  |
| message      |  String  |  The message of the dialog  | "Message" |  -  |
| positiveBtnText |  String  |  The text of the positive button | "Okay" |  -  |
| titleColor      |  Int  | The color of the title | Color.parseColor("#000000") |  -  |
| titleBackgroundColor  |  Int  |  The background color of the title  | Color.parseColor("#FFFFFF")  | -   |
| titleDividerColor      |  Int  |  The color of the title divider  | Color.parseColor("#000000") | -   |
| messageColor      |  Int  |  The color of the message  |  Color.parseColor("#000000") |   - |
| messageBackgroundColor      |  Int  |  The background color of the message   | Color.parseColor("#000000") | -   |
| buttonDividerColor      |  Int  |  The color of the button divider  | Color.parseColor("#000000") |  -  |
| positiveBtnTextColor      |  Int  |  The text color of the positive button  | Color.parseColor("#FFFFFF") |   - |
| positiveBtnBackgroundColor      |  Int  |  The background color of the negative button  | Color.parseColor("#000000") | -   |
| negativeBtnTextColor      |  Int  |  The text color of the negative button  | Color.parseColor("#FFFFFF") |  -  |
| negativeBtnBackgroundColor      |  Int  |  The background color of the negative button  | Color.parseColor("#000000") | -   |
| positiveImageBtnIcon      |  Int  |  The icon of the positive button  | R.drawable.ic_okay | It works if attribute *useIconButtons* is *true* |
| negativeImageBtnIcon      |  Int  |  The icon of the negative button  | R.drawable.ic_cancel | It works if attribute *useIconButtons* is *true* |
| dialogCornerRadius      |  Float  |  The radius of the dialog corners  | 10F |  -  |
| useIconButtons      |  Boolean  |  Enables icon buttons  | true | Makes invisible text buttons for positive and negative buttons |
| cancelOnTouchOutside      |  Boolean  | if true, user can cancel by touching outside of the dialog | true |  -  |
| showTitleDivider      |  Boolean  |  Sets the visibility of the title divider  | true |  -  |
| showButtonDivider      |  Boolean  |  Sets the visibility of the button divider  | true |   - |
| textGravity      |  Int  |  The text gravity of the title and message  | Gravity.CENTER |   - |
| dialoposition|  Int  |  The position of the dialog on the screen.  | Gravity.CENTER |  -  |
| animation |  Animation  | The animation of the dialog  | Animation.LEFT_TO_BOTTOM |  - |

## Animation Options (Enum)
Animation.TRANSPARENT_TO_OPAQUE<br/>
Animation.BOTTOM_TO_TOP<br/>
Animation.TOP_TO_BOTTOM<br/>
Animation.LEFT_TO_RIGHT<br/>
Animation.RIGHT_TO_LEFT<br/>
