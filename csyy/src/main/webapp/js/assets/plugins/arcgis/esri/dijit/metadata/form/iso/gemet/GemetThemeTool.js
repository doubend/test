// All material copyright ESRI, All Rights Reserved, unless otherwise specified.
// See http://js.arcgis.com/3.13/esri/copyright.txt for details.
//>>built
define("esri/dijit/metadata/form/iso/gemet/GemetThemeTool","dojo/_base/declare dojo/_base/lang dojo/has ../../tools/ClickableTool ../../../base/etc/docUtil ./ThemeDialog ../../../../../kernel".split(" "),function(a,d,e,f,g,h,k){a=a([f],{postCreate:function(){this.inherited(arguments)},startup:function(){if(!this._started){var a=g.findGxeContext(this);if(!a||!a.gemetUrl||!a.gemetInspireThemeThesaurus)this.domNode.style.display="none"}},whenToolClicked:function(a,b){if(b&&b.parentXNode){var c=b.getInputValue();
null!==c&&!c.push&&(c=[c]);(new h({gxeDocument:b.parentXNode.gxeDocument,initiallySelectedValues:c,onSelect:d.hitch(this,function(a){b.importValues(null,a)})})).show()}}});e("extend-esri")&&d.setObject("dijit.metadata.form.iso.gemet.GemetThemeTool",a,k);return a});