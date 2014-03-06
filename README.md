Acknowledge
============

This is a general code deposite for the homeless.
Current code being added is Groovy code from the user guide, notes and code from the Java trail.

Below is general usage examples for the markdown format:

- syntax is intended for one purpose: to be used as a format for writing for the web.
- HTML is a publishing format; Markdown is a writing format
- HTML elements — e.g. <div>, <table>, <pre>, <p>, etc. — must be separated from surrounding content by blank lines, and the start and end tags of the block should not be indented with tabs or spaces.
- <span>, <cite>, or <del> — can be used anywhere in a Markdown paragraph, list item, or header.(Markdown syntax is processed within span-level tags.)
- Markdown formatting syntax is not processed within block-level HTML tags.
- < and &. must be escaped as entities, e.g. &lt;, and &amp;.
- ‘AT&T’, you need to write ‘AT&amp;T’.
http://images.google.com/images?num=30&q=larry+bird
http://images.google.com/images?num=30&amp;q=larry+bird
- If you use an ampersand as part of an HTML entity, it remains unchanged; otherwise it will be translated into &amp;.
- &copy; = Markdown will leave it alone.
- if you write: AT&T Markdown = AT&amp;T
- 4 < 5 Markdown = 4 &lt; 5
- When you do want to insert a <br /> break tag using Markdown, you end a line with two or more spaces, then type return.
#one hash#
##two hashes##
###three hashes#
- Headers: Setext
This is an H1: Setext-style headers
==========================
This is an H2: second-level headers
---------------------------------------------------
- Atx-style headers:1-6 hash characters at the start of the line, corresponding to header levels 1-6. For example, open or closed styles supported:
# This is an H1
## This is an H2
###### This is an H6
# This is an H1 #
## This is an H2 ##
### This is an H3 ######
- Blockquotes
> Markdown uses email-style
> characters for blockquoting
- Unordered lists use asterisks, pluses, and hyphens — interchangably — as list markers:
*   Red
+   Green
-   Blue
- Ordered lists use numbers followed by periods:
1.  Bird
2.  McHale
3.  Parish
- This is a normal paragraph:(then indent or tab)
    This is a code block. (like <code>
- a horizontal rule tag (<hr />) by placing three or more hyphens, asterisks, or underscores on a line by themselves (---)
- links:
This is [an example](http://example.com/ "Title") inline link.
[This link](http://example.net/) has no title attribute.
Will produce:
<p>This is <a href="http://example.com/" title="Title">
an example</a> inline link.</p>
<p><a href="http://example.net/">This link</a> has no
title attribute.</p>
- emphasis:
*single asterisks* = <em>single asterisks</em>
_single underscores_ = <em>single underscores</em>
**double asterisks** = <strong>double asterisks</strong>
__double underscores__ = <strong>double underscores</strong>

Here is one example:

![](http://f.cl.ly/items/3435000d3G1E3t3m0J0X/canvas.png)
Canvas is a project to simplify iOS development for both designers and developers.
