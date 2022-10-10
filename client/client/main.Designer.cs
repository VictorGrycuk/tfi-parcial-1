
namespace client
{
    partial class main
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.btnGenerate = new System.Windows.Forms.Button();
            this.txtRequests = new System.Windows.Forms.TextBox();
            this.btnSend = new System.Windows.Forms.Button();
            this.listSentDocuments = new System.Windows.Forms.ListBox();
            this.btnGetStatus = new System.Windows.Forms.Button();
            this.listDocumentStatusOK = new System.Windows.Forms.ListBox();
            this.listDocumentStatusNotOK = new System.Windows.Forms.ListBox();
            this.btnReprocess = new System.Windows.Forms.Button();
            this.groupStep1 = new System.Windows.Forms.GroupBox();
            this.groupStep2 = new System.Windows.Forms.GroupBox();
            this.groupStep3 = new System.Windows.Forms.GroupBox();
            this.label1 = new System.Windows.Forms.Label();
            this.label2 = new System.Windows.Forms.Label();
            this.groupStep0 = new System.Windows.Forms.GroupBox();
            this.label3 = new System.Windows.Forms.Label();
            this.txtEndpoint = new System.Windows.Forms.TextBox();
            this.groupStep1.SuspendLayout();
            this.groupStep2.SuspendLayout();
            this.groupStep3.SuspendLayout();
            this.groupStep0.SuspendLayout();
            this.SuspendLayout();
            // 
            // btnGenerate
            // 
            this.btnGenerate.Location = new System.Drawing.Point(6, 19);
            this.btnGenerate.Name = "btnGenerate";
            this.btnGenerate.Size = new System.Drawing.Size(117, 38);
            this.btnGenerate.TabIndex = 2;
            this.btnGenerate.Text = "Generar 10 archivos";
            this.btnGenerate.UseVisualStyleBackColor = true;
            this.btnGenerate.Click += new System.EventHandler(this.btnGenerate_Click);
            // 
            // txtRequests
            // 
            this.txtRequests.Font = new System.Drawing.Font("Consolas", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtRequests.Location = new System.Drawing.Point(129, 19);
            this.txtRequests.Multiline = true;
            this.txtRequests.Name = "txtRequests";
            this.txtRequests.ReadOnly = true;
            this.txtRequests.ScrollBars = System.Windows.Forms.ScrollBars.Vertical;
            this.txtRequests.Size = new System.Drawing.Size(230, 134);
            this.txtRequests.TabIndex = 3;
            // 
            // btnSend
            // 
            this.btnSend.Enabled = false;
            this.btnSend.Location = new System.Drawing.Point(6, 19);
            this.btnSend.Name = "btnSend";
            this.btnSend.Size = new System.Drawing.Size(117, 38);
            this.btnSend.TabIndex = 4;
            this.btnSend.Text = "Enviar Archivos";
            this.btnSend.UseVisualStyleBackColor = true;
            this.btnSend.Click += new System.EventHandler(this.btnSend_Click);
            // 
            // listSentDocuments
            // 
            this.listSentDocuments.Font = new System.Drawing.Font("Consolas", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listSentDocuments.FormattingEnabled = true;
            this.listSentDocuments.Location = new System.Drawing.Point(129, 19);
            this.listSentDocuments.Name = "listSentDocuments";
            this.listSentDocuments.Size = new System.Drawing.Size(230, 134);
            this.listSentDocuments.TabIndex = 6;
            // 
            // btnGetStatus
            // 
            this.btnGetStatus.Enabled = false;
            this.btnGetStatus.Location = new System.Drawing.Point(6, 38);
            this.btnGetStatus.Name = "btnGetStatus";
            this.btnGetStatus.Size = new System.Drawing.Size(117, 38);
            this.btnGetStatus.TabIndex = 7;
            this.btnGetStatus.Text = "Obtener estado";
            this.btnGetStatus.UseVisualStyleBackColor = true;
            this.btnGetStatus.Click += new System.EventHandler(this.btnGetStatus_Click);
            // 
            // listDocumentStatusOK
            // 
            this.listDocumentStatusOK.Font = new System.Drawing.Font("Consolas", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listDocumentStatusOK.FormattingEnabled = true;
            this.listDocumentStatusOK.Location = new System.Drawing.Point(129, 38);
            this.listDocumentStatusOK.Name = "listDocumentStatusOK";
            this.listDocumentStatusOK.Size = new System.Drawing.Size(230, 134);
            this.listDocumentStatusOK.TabIndex = 8;
            // 
            // listDocumentStatusNotOK
            // 
            this.listDocumentStatusNotOK.Font = new System.Drawing.Font("Consolas", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.listDocumentStatusNotOK.FormattingEnabled = true;
            this.listDocumentStatusNotOK.Location = new System.Drawing.Point(391, 38);
            this.listDocumentStatusNotOK.Name = "listDocumentStatusNotOK";
            this.listDocumentStatusNotOK.Size = new System.Drawing.Size(230, 134);
            this.listDocumentStatusNotOK.TabIndex = 9;
            // 
            // btnReprocess
            // 
            this.btnReprocess.Enabled = false;
            this.btnReprocess.Location = new System.Drawing.Point(6, 134);
            this.btnReprocess.Name = "btnReprocess";
            this.btnReprocess.Size = new System.Drawing.Size(117, 38);
            this.btnReprocess.TabIndex = 10;
            this.btnReprocess.Text = "Reprocesar fallidos";
            this.btnReprocess.UseVisualStyleBackColor = true;
            this.btnReprocess.Click += new System.EventHandler(this.btnReprocess_Click);
            // 
            // groupStep1
            // 
            this.groupStep1.Controls.Add(this.btnGenerate);
            this.groupStep1.Controls.Add(this.txtRequests);
            this.groupStep1.Location = new System.Drawing.Point(12, 123);
            this.groupStep1.Name = "groupStep1";
            this.groupStep1.Size = new System.Drawing.Size(385, 197);
            this.groupStep1.TabIndex = 11;
            this.groupStep1.TabStop = false;
            this.groupStep1.Text = "Generación de requests";
            // 
            // groupStep2
            // 
            this.groupStep2.Controls.Add(this.btnSend);
            this.groupStep2.Controls.Add(this.listSentDocuments);
            this.groupStep2.Location = new System.Drawing.Point(403, 123);
            this.groupStep2.Name = "groupStep2";
            this.groupStep2.Size = new System.Drawing.Size(385, 197);
            this.groupStep2.TabIndex = 12;
            this.groupStep2.TabStop = false;
            this.groupStep2.Text = "Envío de Archivos";
            // 
            // groupStep3
            // 
            this.groupStep3.Controls.Add(this.label2);
            this.groupStep3.Controls.Add(this.label1);
            this.groupStep3.Controls.Add(this.btnReprocess);
            this.groupStep3.Controls.Add(this.btnGetStatus);
            this.groupStep3.Controls.Add(this.listDocumentStatusOK);
            this.groupStep3.Controls.Add(this.listDocumentStatusNotOK);
            this.groupStep3.Location = new System.Drawing.Point(12, 326);
            this.groupStep3.Name = "groupStep3";
            this.groupStep3.Size = new System.Drawing.Size(776, 197);
            this.groupStep3.TabIndex = 13;
            this.groupStep3.TabStop = false;
            this.groupStep3.Text = "Estado y Reprocesamiento";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Location = new System.Drawing.Point(129, 19);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(63, 13);
            this.label1.TabIndex = 11;
            this.label1.Text = "Estados OK";
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(388, 19);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(78, 13);
            this.label2.TabIndex = 12;
            this.label2.Text = "Estados no OK";
            // 
            // groupStep0
            // 
            this.groupStep0.Controls.Add(this.txtEndpoint);
            this.groupStep0.Controls.Add(this.label3);
            this.groupStep0.Location = new System.Drawing.Point(12, 12);
            this.groupStep0.Name = "groupStep0";
            this.groupStep0.Size = new System.Drawing.Size(776, 105);
            this.groupStep0.TabIndex = 14;
            this.groupStep0.TabStop = false;
            this.groupStep0.Text = "Configuración";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(7, 44);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(72, 13);
            this.label3.TabIndex = 13;
            this.label3.Text = "API Endpoint:";
            // 
            // txtEndpoint
            // 
            this.txtEndpoint.Font = new System.Drawing.Font("Consolas", 8.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txtEndpoint.Location = new System.Drawing.Point(85, 42);
            this.txtEndpoint.Name = "txtEndpoint";
            this.txtEndpoint.Size = new System.Drawing.Size(294, 20);
            this.txtEndpoint.TabIndex = 14;
            this.txtEndpoint.Text = "http://localhost:8080/";
            // 
            // main
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(812, 543);
            this.Controls.Add(this.groupStep0);
            this.Controls.Add(this.groupStep3);
            this.Controls.Add(this.groupStep2);
            this.Controls.Add(this.groupStep1);
            this.FormBorderStyle = System.Windows.Forms.FormBorderStyle.FixedToolWindow;
            this.Name = "main";
            this.Text = "Main";
            this.groupStep1.ResumeLayout(false);
            this.groupStep1.PerformLayout();
            this.groupStep2.ResumeLayout(false);
            this.groupStep3.ResumeLayout(false);
            this.groupStep3.PerformLayout();
            this.groupStep0.ResumeLayout(false);
            this.groupStep0.PerformLayout();
            this.ResumeLayout(false);

        }

        #endregion
        private System.Windows.Forms.Button btnGenerate;
        private System.Windows.Forms.TextBox txtRequests;
        private System.Windows.Forms.Button btnSend;
        private System.Windows.Forms.ListBox listSentDocuments;
        private System.Windows.Forms.Button btnGetStatus;
        private System.Windows.Forms.ListBox listDocumentStatusOK;
        private System.Windows.Forms.ListBox listDocumentStatusNotOK;
        private System.Windows.Forms.Button btnReprocess;
        private System.Windows.Forms.GroupBox groupStep1;
        private System.Windows.Forms.GroupBox groupStep2;
        private System.Windows.Forms.GroupBox groupStep3;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
        private System.Windows.Forms.GroupBox groupStep0;
        private System.Windows.Forms.TextBox txtEndpoint;
        private System.Windows.Forms.Label label3;
    }
}

