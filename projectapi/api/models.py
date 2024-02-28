from django.db import models

class Contact(models.Model):
    Name = models.CharField(max_length = 200, null = False, blank=False)
    Phn_number = models.IntegerField(max_length = 100)
    Adhar_card = models.IntegerField(max_length = 100,null = False, blank=False)


    def __str__(self) :
        return self.Name
# Create your models here.
